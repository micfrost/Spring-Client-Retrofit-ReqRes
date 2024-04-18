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

        // Asynchronously update a user using PUT
        updateUserAsync(apiServiceUser, 1);

        // Asynchronously delete a user using DELETE
        deleteUserAsync(apiServiceUser, 1);
    }

    // fetch
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

    // create
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
                    System.out.println("- - - - -");
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

    // update
    private static void updateUserAsync(ApiServiceUser service, int userId) {
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Updated Michalski");
        updatedUser.setEmail("UpdatedEmailofMichalski@example.com");

        Call<User> updateUserCall = service.updateUser(userId, updatedUser);
        updateUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    System.out.println("PUT method - updated User:");
                    System.out.println("User ID: " + response.body().getId());
                    System.out.println("User Name: " + response.body().getName());
                    System.out.println("User Email: " + response.body().getEmail());
                    System.out.println("- - - - -");
                } else {
                    System.out.println("Failed to update user: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Error occurred while updating user: " + t.getMessage());
            }
        });
    }

    private static void deleteUserAsync(ApiServiceUser service, int userId) {
        Call<Void> deleteUserCall = service.deleteUser(userId);
        deleteUserCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    System.out.println("DELETE method - User deleted successfully.");
                    System.out.println("- - - - -");
                } else {
                    System.out.println("Failed to delete user: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("Error occurred while deleting user: " + t.getMessage());
            }
        });
    }
}