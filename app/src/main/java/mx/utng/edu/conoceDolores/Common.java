package mx.utng.edu.conoceDolores;

import mx.utng.edu.conoceDolores.Remote.IGoogleApi;
import mx.utng.edu.conoceDolores.Remote.RetrofitClient;

/**
 * Created by Paola on 20/03/2018.
 */

public class Common {
    public static final String baseURL = "https://googleapis.com";
    public static IGoogleApi getGoogleApi(){
        return RetrofitClient.getClient(baseURL).create(IGoogleApi.class);
    }
}
