package dev.micfro.retrofitca;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainAsync {

    public static void main(String[] args) {
        ApiServiceUser apiServiceUser = RetrofitClient.getClient().create(ApiServiceUser.class);
        System.out.println(" ----------------------------------- ");
        System.out.println("ASYNC REQUESTS");
        System.out.println(" ----------------------------------- ");
        // Asynchronously retrieve a user by ID using GET
        retrieveUserAsync(apiServiceUser, 1);

        // Asynchronously create a new user using POST
        createUserAsync(apiServiceUser);

        // Asynchronously update a user using PUT
        updateUserAsync(apiServiceUser, 1);

        // Asynchronously delete a user using DELETE
        deleteUserAsync(apiServiceUser, 1);
    }

    private static void retrieveUserAsync(ApiServiceUser service, Integer id) {
        Call<UserResponse> getUserCall = service.getUserByID(id);
        getUserCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserResponse.UserData user = response.body().getData();
                    System.out.println("GET method - fetch an existing User:");
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User Name: " + user.getName());
                    System.out.println("User Color: " + user.getColor());
                    System.out.println("User Year: " + user.getYear());
                    System.out.println("Pantone Value: " + user.getPantoneValue());
                    System.out.println(" ----------------------------------- ");
                } else {
                    System.out.println("Failed to retrieve user: HTTP Error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                System.out.println("Error occurred while fetching user: " + t.getMessage());
            }
        });
    }

    private static void createUserAsync(ApiServiceUser service) {
        User newUser = new User();
        newUser.setName("New Color Name");
        newUser.setYear(2022);
        newUser.setColor("#123456");
        newUser.setPantoneValue("17-5104");

        Call<User> createUserCall = service.createUser(newUser);
        createUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
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
                    System.out.println("Failed to create user: HTTP Error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Error occurred while creating user: " + t.getMessage());
            }
        });
    }

    private static void updateUserAsync(ApiServiceUser service, int userId) {
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Updated Color Name");
        updatedUser.setYear(2023);
        updatedUser.setColor("#654321");
        updatedUser.setPantoneValue("18-5104");

        Call<User> updateUserCall = service.updateUser(userId, updatedUser);
        updateUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
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
                    System.out.println("Failed to update user: HTTP Error " + response.code());
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
                    System.out.println(" ----------------------------------- ");
                } else {
                    System.out.println("Failed to delete user: HTTP Error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("Error occurred while deleting user: " + t.getMessage());
            }
        });
    }
}
