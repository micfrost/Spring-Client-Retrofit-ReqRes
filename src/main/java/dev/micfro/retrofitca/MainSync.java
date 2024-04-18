package dev.micfro.retrofitca;

import dev.micfro.retrofitca.RetrofitClient;
import retrofit2.Call;
import retrofit2.Response;

public class MainSync {

    public static void main(String[] args) {
        ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);

        // Synchronously fetch a user using GET
        retrieveUserSync(apiServiceUser, 2);

        // Synchronously create a user using POST
        createUserSync(apiServiceUser);

        // Synchronously update a user using PUT
        updateUserSync(apiServiceUser, 2);

        // Synchronously delete a user using DELETE
        deleteUserSync(apiServiceUser, 2);
    }

    private static void retrieveUserSync(ApiServiceUser service, int userId) {
        try {
            Call<User> call = service.getUserByID(userId);
            Response<User> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                User user = response.body();
                System.out.println("- - - - -");
                System.out.println("GET method - fetch an existing User:");
                System.out.println("User ID: " + user.getId());
                System.out.println("User Name: " + user.getName());
                System.out.println("User Email: " + user.getEmail());
                System.out.println("- - - - -");
            } else {
                System.out.println("Response body was null or response was not successful. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while making the request: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createUserSync(ApiServiceUser service) {
        User newUser = new User();
        newUser.setName("Michal Frost");
        newUser.setEmail("MichalFrost@example.com");

        try {
            Call<User> call = service.createUser(newUser);
            Response<User> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                User user = response.body();
                System.out.println("POST method -  create new User:");
                System.out.println("User ID: " + user.getId());
                System.out.println("User Name: " + user.getName());
                System.out.println("User Email: " + user.getEmail());
                System.out.println("- - - - -");
            } else {
                System.out.println("Failed to create user. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while creating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void updateUserSync(ApiServiceUser service, int userId) {
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Updated Michalsky");
        updatedUser.setEmail("UpdatedEmailMichalsy@example.com");

        try {
            Call<User> call = service.updateUser(userId, updatedUser);
            Response<User> response = call.execute();
            if (response.isSuccessful()) {
                User user = response.body();
                System.out.println("PUT method - updated User:");
                System.out.println("User ID: " + user.getId());
                System.out.println("User Name: " + user.getName());
                System.out.println("User Email: " + user.getEmail());
                System.out.println("- - - - -");
            } else {
                System.out.println("Failed to update user. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteUserSync(ApiServiceUser service, int userId) {
        try {
            Call<Void> call = service.deleteUser(userId);
            Response<Void> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println("DELETE method - User deleted successfully.");
                System.out.println("- - - - -");
            } else {
                System.out.println("Failed to delete user. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while deleting user: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
