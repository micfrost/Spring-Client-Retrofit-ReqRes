package dev.micfro.retrofitcaAsync;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServiceUser {

    // make a GET request to the specified URL
    @GET("users/{userId}")
    Call<User> getUserByID(@Path("userId") int userId);

}