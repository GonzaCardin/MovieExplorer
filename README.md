# Movie Exprlorer Application

## Description

This project is a movie search and management application built with Java and Spring Boot. It allows users to search for movies by title or genre, view movie details, and perform CRUD (Create, Read, Update, Delete) operations on movie records.

## Technologies Used

- **Java 17**
- **Spring Boot**: Framework for developing Java applications.
- **JPA/Hibernate**: For database management.
- **REST API**: For communication between client and server.
- **Postman**: For testing API endpoints.

## Main Endpoints

### Movies

- **GET /movies/search/title**: Search for movies by title.
- **GET /movies/search/genre**: Search for movies by genre.
- **GET /movies/details/{id}**: Get details of a movie by ID.
- **POST /movies/add**: Add a new movie 
- **PUT /movies/update/{id}**: Update movie information 
- **DELETE /movies/delete/{id}**: Delete a movie 

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- MYSQL (or your chosen database)
- IDE (e.g., IntelliJ, Eclipse, VScode)