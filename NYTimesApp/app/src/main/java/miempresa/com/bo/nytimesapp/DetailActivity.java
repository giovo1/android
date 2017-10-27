package miempresa.com.bo.nytimesapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private SessionManager session;
    private NewsItem newsItem;
    private TextView textHeadline;
    private TextView textSnippet;
    private TextView textSource;
    private TextView textPubDate;
    private TextView textUrl;
    private Toolbar mToolBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.mToolBar = (Toolbar) findViewById(R.id.toolbarDetail);

        if (this.mToolBar != null) {
            setSupportActionBar(this.mToolBar);
        }

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(getApplicationContext());
        newsItem = session.getNewsItem();

        textHeadline = (TextView) findViewById(R.id.textHeadline);
        textHeadline.setText(newsItem.getHeadline());
        textSnippet = (TextView) findViewById(R.id.textSnippet);
        textSnippet.setText(newsItem.getSnippet());

        textSource = (TextView) findViewById(R.id.textSource);
        textSource.setText(newsItem.getSource());
        textPubDate = (TextView) findViewById(R.id.textPubDate);
        textPubDate.setText(newsItem.getPub_date());
        textUrl = (TextView) findViewById(R.id.textUrl);
        textUrl.setText(newsItem.getWeb_url());

        imageView = (ImageView) findViewById(R.id.imageView);

        if (newsItem.getUrl_image_xlarge().length()>0) {
            Picasso.with(this).load(ConstantsRestApi.URL_IMAGE + newsItem.getUrl_image_xlarge()).into(imageView);
        }else{
            imageView.setImageResource(R.drawable.no_image);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
