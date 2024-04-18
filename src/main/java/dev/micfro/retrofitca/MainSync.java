package dev.micfro.retrofitca;

import retrofit2.Call;
import retrofit2.Response;

public class MainSync {

    public static void main(String[] args) {
        ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);
        System.out.println(" ----------------------------------- ");
        System.out.println("SYNC REQUESTS");
        System.out.println(" ----------------------------------- ");

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
            Call<UserResponse> call = service.getUserByID(userId);
            Response<UserResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                UserResponse.UserData userData = response.body().getData();
                System.out.println("GET method - fetch an existing User:");
                System.out.println("User ID: " + userData.getId());
                System.out.println("User Name: " + userData.getName());
                System.out.println("User Color: " + userData.getColor());
                System.out.println("User Year: " + userData.getYear());
                System.out.println("Pantone Value: " + userData.getPantoneValue());
                System.out.println(" ----------------------------------- ");
            } else {
                System.out.println("Response was not successful. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while making the request: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static void createUserSync(ApiServiceUser service) {
        User newUser = new User();
        newUser.setName("New Color Name");
        newUser.setYear(2022);
        newUser.setColor("#123456");
        newUser.setPantoneValue("17-5104");

        try {
            Call<User> call = service.createUser(newUser);
            Response<User> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                User user = response.body();
                System.out.println("POST method - create new User:");
                System.out.println("User ID: " + user.getId());
                System.out.println("User Name: " + user.getName());
                System.out.println("User Color: " + user.getColor());
                System.out.println("User Year: " + user.getYear());
                System.out.println("Pantone Value: " + user.getPantoneValue());
                System.out.println(" ----------------------------------- ");
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
        updatedUser.setName("Updated Color Name");
        updatedUser.setYear(2023);
        updatedUser.setColor("#654321");
        updatedUser.setPantoneValue("18-5104");

        try {
            Call<User> call = service.updateUser(userId, updatedUser);
            Response<User> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                User user = response.body();
                System.out.println("PUT method - updated User:");
                System.out.println("User ID: " + user.getId());
                System.out.println("User Name: " + user.getName());
                System.out.println("User Color: " + user.getColor());
                System.out.println("User Year: " + user.getYear());
                System.out.println("Pantone Value: " + user.getPantoneValue());
                System.out.println(" ----------------------------------- ");
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
                System.out.println(" ----------------------------------- ");
            } else {
                System.out.println("Failed to delete user. HTTP Error: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while deleting user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
