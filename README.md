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

- **src/main/java/com/example/demo:** Contains the main Java source files.
  - **controller:** RESTful controller classes defining API endpoints.
  - **model:** Entity classes representing domain objects.
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

4. **Run the application:**
java -jar target/spring-boot-crud-example-0.0.1-SNAPSHOT.jar


5. **Access the application:**
Open a web browser and navigate to [http://localhost:8080](http://localhost:8080) to access the Swagger UI, which provides a user-friendly interface to interact with the API endpoints.

## API Endpoints

The following API endpoints are available:

- `GET /api/products`: Retrieve all products.
- `GET /api/products/{id}`: Retrieve a product by ID.
- `POST /api/products`: Create a new product.
- `PUT /api/products/{id}`: Update an existing product.
- `DELETE /api/products/{id}`: Delete a product by ID.

For detailed documentation and usage examples, refer to the Swagger UI available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) after running the application locally.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
