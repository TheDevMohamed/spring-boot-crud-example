# Spring Boot CRUD Example

This is a simple example project demonstrating CRUD (Create, Read, Update, Delete) operations using Spring Boot.

## Overview

This project showcases a basic implementation of CRUD operations for managing a collection of entities using Spring Boot and Spring Data JPA. It provides RESTful API endpoints to perform these operations, which can be consumed by client applications.

## Technologies Used

- **Spring Boot:** A powerful framework for building web applications with minimal setup and configuration.
- **Spring Data JPA:** Part of the larger Spring Data project, it makes it easy to implement JPA-based repositories.
- **H2 Database:** An in-memory database used for demonstration purposes. It allows quick setup without requiring external database configuration.

## Project Structure

The project structure is organized as follows:

- **src/main/java/com/alkhenaizi/springCrud:** Contains the main Java source files.
  - **controller:** RESTful controller classes defining API endpoints.
  - **domain:** Entity classes representing domain objects.
  - **repository:** Spring Data JPA repository interfaces.
  - **service:** Service classes providing business logic.
- **src/main/resources:** Contains application properties and database schema initialization script.
  - **application.properties:** Configuration properties for the application.
  - **data.sql:** Script to initialize the H2 database with sample data.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the repository:**
git clone https://github.com/TheDevMohamed/spring-boot-crud-example.git

2. **Navigate to the project directory:**
cd spring-boot-crud-example

3. **Build the project:**
mvn clean install

4. **Run the PostgreSQL database using Docker:**
docker-compose up -d

5. **Run the application:**
java -jar target/spring-boot-crud-example-0.0.1-SNAPSHOT.jar

6. **Access the application:**
Open a web browser and navigate to [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Books

- `GET /books/{isbn}`: Retrieve a book by ISBN.
- `PUT /books/{isbn}`: Upsert a book.

### Authors

- `GET /api/authors`: Retrieve all authors.
- `POST /authors`: Create a new author.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
