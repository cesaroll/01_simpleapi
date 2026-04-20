# Simple API

A simple REST API built with Spring Boot, demonstrating a standard layered architecture with full CRUD operations.

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA + Hibernate
- H2 in-memory database
- Maven

## Getting Started

**Run the application:**
```bash
mvn spring-boot:run
```

The server starts on `http://localhost:8080`.

**Run tests:**
```bash
mvn test
```

## API Endpoints

Base path: `/api/items`

| Method | Endpoint         | Status          | Description       |
|--------|------------------|-----------------|-------------------|
| GET    | `/api/items`     | 200 OK          | List all items    |
| GET    | `/api/items/{id}`| 200 OK          | Get item by ID    |
| POST   | `/api/items`     | 201 Created     | Create an item    |
| PUT    | `/api/items/{id}`| 200 OK          | Update an item    |
| DELETE | `/api/items/{id}`| 204 No Content  | Delete an item    |

### Request Body (POST / PUT)

```json
{
  "name": "Item name",
  "description": "Optional description"
}
```

### Error Response

```json
{
  "status": 404,
  "error": "Resource not found",
  "timestamp": "2026-04-17T10:00:00Z"
}
```

## H2 Console

The H2 database console is available at `http://localhost:8080/h2-console`.

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(leave blank)*

## Project Structure

```
src/main/java/com/example/simpleapi/
├── controller/       # REST controllers
├── service/          # Business logic
├── repository/       # JPA repositories
├── entity/           # JPA entities
├── dto/              # Request payloads (Java records)
└── exception/        # Custom exceptions and global handler
```
