package miempresa.com.bo.nytimesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPointApi {
    @GET(ConstantsRestApi.URL_BOOK)
//    Call<NewsResponse> getList(@Query("apiKey") String apiKey, @Query("query") String query, @Query("startDate") String startDate, @Query("endtDate") String endDate);
    Call<NewsResponse> getList(@Query("apiKey") String apiKey, @Query("query") String query);
}