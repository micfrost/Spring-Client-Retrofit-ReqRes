
# RetrofitCA API Client

## Overview
The retrofit-ca application is designed to demonstrate the integration of Retrofit with Spring Boot for making HTTP requests to an external API. This example uses the JSONPlaceholder as a mock backend for testing CRUD operations on users.

## Features
- **Synchronous and Asynchronous Requests:** Demonstrates both synchronous (`MainSync.java`) and asynchronous (`MainAsync.java`) operations to fetch and post user data.
- **Error Handling:** Includes basic error handling for HTTP requests.
- **GSON Integration:** Uses Gson for JSON serialization and deserialization.

## Requirements
- Java JDK 11 or later
- Retrofit2
- Gson

## Installation
1. Clone the repository to your local machine.
2. Ensure Java JDK 11 (or later) is installed.
3. Import the project into an IDE that supports Java (e.g., IntelliJ IDEA, Eclipse).
4. Add Retrofit and Gson libraries to your project. If you're using Maven, add the following dependencies to your `pom.xml`:

<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>retrofit</artifactId>
    <version>2.9.0</version>
</dependency>
<dependency>
    <groupId>com.squareup.retrofit2</groupId>
    <artifactId>converter-gson</artifactId>
    <version>2.9.0</version>
</dependency>

## Usage 
The application supports both synchronous and asynchronous operations to create, retrieve, update, and delete user data. Below are the examples of how you can execute these operations.

### Synchronous Execution
Run the MainSync.java class. This class demonstrates synchronous calls to the API:

- Fetch a user by ID
- Create a new user
- Update an existing user
- Delete a user

### Asynchronous Execution
  Run the MainAsync.java class. This class demonstrates asynchronous calls to the API using callbacks:

- Fetch a user by ID asynchronously
- Create a new user asynchronously
- Update an existing user asynchronously
- Delete a user asynchronously


## Author
Created by Michal Frost

![Screenshot from 2024-04-18 12-09-33.png](src%2Fmain%2Fresources%2Fimages%2FScreenshot%20from%202024-04-18%2012-09-33.png)
![Screenshot from 2024-04-18 12-09-47.png](src%2Fmain%2Fresources%2Fimages%2FScreenshot%20from%202024-04-18%2012-09-47.png)