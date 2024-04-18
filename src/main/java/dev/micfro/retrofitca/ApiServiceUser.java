package dev.micfro.retrofitca;


import retrofit2.Call;
import retrofit2.http.*;

public interface ApiServiceUser {

    // make a GET request to the specified URL
    @GET("users/{userId}")
    Call<User> getUserByID(@Path("userId") int userId);

    @POST("users")
    Call<User> createUser(@Body User user);

    @PUT("users/{userId}")
    Call<User> updateUser(@Path("userId") int userId, @Body User user);

    @DELETE("users/{userId}")
    Call<Void> deleteUser(@Path("userId") int userId);


}