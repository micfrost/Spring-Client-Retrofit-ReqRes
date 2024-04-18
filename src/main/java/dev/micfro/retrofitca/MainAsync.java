package dev.micfro.retrofitcaAsync;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main {

    public static void main(String[] args) {
        // Create an instance of the ApiServiceUser interface
        ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);

        // Asynchronously retrieve a user by ID
        Call<User> call = apiServiceUser.getUserByID(1);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // The response is successful and the body is not null
                    User user = response.body();
                    System.out.println("User Details:");
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User Name: " + user.getName());
                    System.out.println("User Email: " + user.getEmail());
                } else {
                    // The response is successful but the body might be null or there is an error
                    System.out.println("Response was not successful or was empty: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // An error occurred during the network request
                System.out.println("Error occurred while fetching user data: " + t.getMessage());
            }
        });
    }
}