package dev.micfro.retrofitca;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // define the base URL
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    // create a Retrofit instance
    private static Retrofit retrofit = null;

    // create a client method
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // add Gson converter factory to convert JSON to POJO
                    .build();
        }
        return retrofit;
    }

}
