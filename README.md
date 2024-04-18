# User Management System - Retrofit Client

## Project Overview
This User Management System is a Java-based application developed with Spring Boot and Retrofit. It facilitates operations related to user management, including creating, retrieving, updating, and deleting user data. The application interfaces with an external API to perform these operations both synchronously and asynchronously.


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

## Screenshots
### SYNC Request
![Screenshot from 2024-04-18 15-31-14.png](src%2Fmain%2Fresources%2Fimages%2FScreenshot%20from%202024-04-18%2015-31-14.png)

### ASYNC Request
![Screenshot from 2024-04-18 15-32-09.png](src%2Fmain%2Fresources%2Fimages%2FScreenshot%20from%202024-04-18%2015-32-09.png)