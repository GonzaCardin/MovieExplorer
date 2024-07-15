# Movie Explorer Application

## Description

The Movie Explorer Application is a movie search and management platform built with Java and Spring Boot. It enables users to search for movies by title or genre, view detailed information about movies, and perform CRUD (Create, Read, Update, Delete) operations on movie records.

## Technologies Used

- **Java 17**
- **Spring Boot**: Framework for developing Java applications.
- **Spring Security**: For authentication and authorization.
- **JPA/Hibernate**: For database management.
- **REST API**: For communication between client and server.
- **Postman**: For testing API endpoints.

## Main Endpoints

### Movies

- **GET /movies/search/title**: Search for movies by title.
- **GET /movies/search/genre**: Search for movies by genre.
- **GET /movies/details/{id}**: Get details of a movie by ID.
- **POST /movies/add**: Add a new movie.
- **PUT /movies/update/{id}**: Update movie information.
- **DELETE /movies/delete/{id}**: Delete a movie.

### Authentication

- **POST /auth/login**: Authenticate user and return a JWT token.
- **POST /auth/register**: Register a new user.

## Security and Authentication

The application uses Spring Security for securing the REST API. Users must authenticate to access certain endpoints. 

### Roles

- **ADMIN**: Full access to manage movies and users.
- **USER**: Access to search and view movies.

### Token-Based Authentication

Upon successful login, a JWT token is returned, which should be included in the `Authorization` header for subsequent requests to protected endpoints.

## Frontend Implementation

The frontend implementation is still in progress. The application will feature:

- **Movie Cards**: Display a list of movies with relevant information.
- **Movie Details**: A detailed view for each movie.
- **Search Functionality**: A search bar to find movies by title or genre.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- MYSQL (or your chosen database)
-   -> CREATE DATABASE movies.  <- Use this dml in MYSQL
-   ->Change in application properties to your username and password database.
- IDE (e.g., IntelliJ, Eclipse, VS code)