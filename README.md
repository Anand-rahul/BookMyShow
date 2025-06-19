# BookMyShow Backend

This repository contains a sample Spring Boot application that mimics basic features of a movie ticket booking system similar to BookMyShow.

## Features

- Manage **Movies**, **Theatres**, **Shows**, **Bookings**, and **Users** using JPA entities and repositories.
- JWT based authentication via Spring Security.
- API documentation through SpringDoc / Swagger (`/swagger-ui.html`).
- PostgreSQL database with initial seed data provided in `import.sql`.

## Prerequisites

- Java 17
- Maven 3 (the repository includes the Maven Wrapper so `./mvnw` can be used)
- PostgreSQL running locally with a database named `bmsDb` and credentials matching `application.properties` (user `postgres`, password `postgres`)

## Running the application

1. Clone the repository and navigate into it.
   ```bash
   git clone <repo-url>
   cd BookMyShow
   ```
2. Ensure PostgreSQL is running and a database `bmsDb` exists. The schema is created automatically on startup (`spring.jpa.hibernate.ddl-auto=create-drop`) and initial data is loaded from `src/main/resources/import.sql`.
3. Start the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Once running, the API is available at `http://localhost:8080` and Swagger UI can be accessed at `http://localhost:8080/swagger-ui.html`.

## Running tests

To execute the unit tests run:
```bash
./mvnw test
```

## Notes

The default configuration stores database credentials and the JWT secret directly in `application.properties`. For production use, move these values to environment variables or a dedicated secrets manager.
