
# RetrofitCA API Client

## Overview
This project implements an API client using Retrofit and Gson in Java, aimed at demonstrating synchronous and asynchronous HTTP requests. The RetrofitCA client allows users to retrieve and create user data from a mock online REST service.

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

## Project Structure
- ApiServiceUser.java: Interface for Retrofit API calls.
- User.java: Model class representing a user.
- RetrofitClient.java: Provides the Retrofit instance.
- MainSync.java: Contains the main method for synchronous server requests.
- MainAsync.java: Contains the main method for asynchronous server requests.
- RetrofitCaApplication.java: Spring Boot application launcher.

## Example Usage

- Synchronous User Fetch:
Execute MainSync.java to fetch user details synchronously from the API.

- Asynchronous User Creation:
Execute MainAsync.java to asynchronously create a new user in the system.
## Author
Created by Michal Frost