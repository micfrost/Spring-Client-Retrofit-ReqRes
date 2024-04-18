package dev.micfro.retrofitcaSync;

import dev.micfro.retrofitcaAsync.ApiServiceUser;
import dev.micfro.retrofitcaAsync.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class Main {

        public static void main(String[] args) {
            // Create an instance of the ApiServiceUser interface to make the HTTP request to the API endpoint
            ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);

            // Synchronous execute method to make the HTTP request
            try {
                Call<User> call = apiServiceUser.getUserByID(2); // Attempt to retrieve the user with ID 2
                Response<User> response = call.execute(); // Execute the call synchronously and retrieve the response from the server

                if (response.isSuccessful()) {
                    User user = response.body(); // Get the response body and store it in a User object
                    if (user != null) {
                        System.out.println("User Details:");
                        System.out.println("User ID: " + user.getId());
                        System.out.println("User Name: " + user.getName());
                        System.out.println("User Email: " + user.getEmail());
                    } else {
                        System.out.println("Response body was null.");
                    }
                } else {
                    // Error handling for unsuccessful response
                    System.out.println("Error: " + response.errorBody().string());
                }
            } catch (Exception e) {
                // This catch is broad, ideally specify exceptions like IOException or HttpException if applicable
                System.out.println("Error occurred while making the request: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }