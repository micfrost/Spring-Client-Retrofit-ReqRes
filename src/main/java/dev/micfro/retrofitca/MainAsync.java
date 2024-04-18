package dev.micfro.retrofitca;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAsync {

    public static void main(String[] args) {
        ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);

        // Asynchronously retrieve a user by ID using GET
        retrieveUserAsync(apiServiceUser, 1);

        // Asynchronously create a new user using POST
        createUserAsync(apiServiceUser);
    }

    private static void retrieveUserAsync(ApiServiceUser service, int userId) {
        Call<User> getUserCall = service.getUserByID(userId);
        getUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    System.out.println("GET method - fetch an existing User:");
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User Name: " + user.getName());
                    System.out.println("User Email: " + user.getEmail());
                    System.out.println("- - - - -");
                } else {
                    System.out.println("Response was not successful or was empty: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Error occurred while fetching user data: " + t.getMessage());
            }
        });
    }

    private static void createUserAsync(ApiServiceUser service) {
        User newUser = new User();
        newUser.setName("Michal Frostr");
        newUser.setEmail("MichalFrost@example.com");

        Call<User> createUserCall = service.createUser(newUser);
        createUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();
                    System.out.println("POST method -  create new User:");
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User Name: " + user.getName());
                    System.out.println("User Email: " + user.getEmail());
                } else {
                    System.out.println("Failed to create user: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Error occurred while creating user: " + t.getMessage());
            }
        });
    }
}
