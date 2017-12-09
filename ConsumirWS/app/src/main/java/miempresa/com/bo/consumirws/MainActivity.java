package miempresa.com.bo.consumirws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String searchRecipe = "red apple";
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.connexionApi(restApiAdapter.buildGsonDeserializedRecipe(searchRecipe));
        Call<RecipeResponse> recipeResponseCall = endPointApi.getList(searchRecipe);
        recipeResponseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                RecipeResponse recipe = response.body();
                System.out.println( new Gson().toJson(recipe));
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                System.out.println("Ocurrio un error" + t.getLocalizedMessage());
            }
        });
    }
}

