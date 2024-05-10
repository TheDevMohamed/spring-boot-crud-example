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
