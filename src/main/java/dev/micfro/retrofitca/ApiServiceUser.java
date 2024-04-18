package dev.micfro.retrofitca;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiServiceUser {
    @GET("user/{id}")
    Call<UserResponse> getUserByID(@Path("id") int id);


    @POST("users")
    Call<User> createUser(@Body User user);

    @PUT("users/{userId}")
    Call<User> updateUser(@Path("userId") int userId, @Body User user);

    @DELETE("users/{userId}")
    Call<Void> deleteUser(@Path("userId") int userId);

    @GET("users")
    Call<UserListResponse> getUsers(@Query("page") int page);
}
