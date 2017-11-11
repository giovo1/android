package miempresa.com.bo.nytimesapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RecyclerView recyclerView;
    private SessionManager session;
    private DataBaseOpenHelper mDBOpenHelper;
    private PopupWindow mPopupWindow;
    private LinearLayout mLinearLayout;
    public static final int SIZE_BUCLE_CONEXION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        if (!isConexion(getApplicationContext())){
            Toast.makeText(this, getString(R.string.text_error_conexion),Toast.LENGTH_LONG).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDBOpenHelper = new DataBaseOpenHelper(this);
        mLinearLayout = (LinearLayout) findViewById(R.id.layoutPrincipal);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);


        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setQueryHint(getText(R.string.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (!isConexion(getApplicationContext())){
                    Toast.makeText(MainActivity.this, R.string.text_error_conexion,Toast.LENGTH_LONG).show();
                }

                String data=query.trim();
                for(int i=0;i<data.length();i++)
                {
                    if (!Character.isLetterOrDigit(data.charAt(i))&&!Character.isSpaceChar(data.charAt(i))) {
                        Toast.makeText(MainActivity.this, R.string.text_error_search_query, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }

                makeNewsSearch(query.trim());

                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
//                textView.setText(newText);
                return true;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_clean){
            cleanNewsSearch();
            return true;
        }else if (item.getItemId() == R.id.action_last_searches){
            showLastSearches();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cleanNewsSearch(){
        List<NewsItem> newsList = new ArrayList<>();
        NewsItemListAdapter newsItemListAdapter = new NewsItemListAdapter(newsList, getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(newsItemListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void makeNewsSearch(String query){

        cleanNewsSearch();

        mDBOpenHelper.addSearchQuery(query);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.connexionApi(restApiAdapter.buildGsonDeserializedNews(query));
        Call<NewsResponse> newsResponseCall = endPointApi.getList("1111144", query);
        newsResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse news = response.body();
//                System.out.println( new Gson().toJson(news));

                NewsItemListAdapter newsItemListAdapter = new NewsItemListAdapter(news.getItemList(), getApplicationContext());
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setAdapter(newsItemListAdapter);
                newsItemListAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(NewsItem item) {
                        session = new SessionManager(getApplicationContext());
                        session.saveNewsItem(item);

                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        startActivity(i);
                    }
                });
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                System.out.println("Ocurrio un error " + t.getLocalizedMessage());
//                t.printStackTrace();
            }
        });

    }

    public boolean isConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < SIZE_BUCLE_CONEXION; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    public void showLastSearches(){

        // Initialize a new instance of LayoutInflater service
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        View customView = inflater.inflate(R.layout.popup_last_searches,null);

        TextView textView = (TextView)  customView.findViewById(R.id.txt_last_searches);
        textView.setText(getLastSearches());;

        // Initialize a new instance of popup window
        mPopupWindow = new PopupWindow(
                customView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        // Set an elevation value for popup window
        // Call requires API level 21
        if(Build.VERSION.SDK_INT>=21){
            mPopupWindow.setElevation(5.0f);
        }

        // Get a reference for the custom view close button
        ImageButton closeButton = (ImageButton) customView.findViewById(R.id.action_close);

        // Set a click listener for the popup window close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss the popup window
                mPopupWindow.dismiss();
            }
        });

        // Finally, show the popup window at the center location of root relative layout
        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
    }

    public String getLastSearches(){
        String sReturn = "";
        ArrayList<String> listSearchQueries = mDBOpenHelper.getSearchQueries();
        for (int i=0; i < listSearchQueries.size(); i++ ){
            sReturn = sReturn + listSearchQueries.get(i) + "\n";
        }

        return sReturn;
    }
}
