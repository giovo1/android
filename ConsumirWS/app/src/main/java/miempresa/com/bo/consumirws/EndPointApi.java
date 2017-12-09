package miempresa.com.bo.consumirws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPointApi {
    //?jscmd=data&format=json&bibkeys=ISBN:
    @GET(ConstantsRestApi.URL_RECIPE)
    Call<RecipeResponse> getList(@Query("searchRecipe") String searchRecipe );
}

