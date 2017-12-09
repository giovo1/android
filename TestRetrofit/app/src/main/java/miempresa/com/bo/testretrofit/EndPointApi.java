package miempresa.com.bo.testretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPointApi {
    //?jscmd=data&format=json&bibkeys=ISBN:
    @GET(ConstantsRestApi.URL_BOOK)
    Call<BookResponse> getList(@Query("jscmd") String jscmd, @Query("format") String format, @Query("bibkeys") String bibkeys);

}