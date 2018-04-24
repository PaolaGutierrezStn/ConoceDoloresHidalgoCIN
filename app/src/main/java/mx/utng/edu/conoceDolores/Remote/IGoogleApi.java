package mx.utng.edu.conoceDolores.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Paola on 20/03/2018.
 */

public interface IGoogleApi {
    @GET
    Call<String> getDataFromGoogleApi(@Url String url);
}
