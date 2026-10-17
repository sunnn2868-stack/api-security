# Project 3: API Security and Access Control

## Overview

This project demonstrates API security and access control using Java 21 and Spring Boot. It includes authentication, role-based authorization, request validation, and consistent error responses.

## Technologies

- Java 21
- Spring Boot 4.1.1
- Spring Security
- Spring Web
- Jakarta Bean Validation
- Maven

## Features

- **Authentication:** Protects private endpoints using Spring Security.
- **Role-based access control:** Restricts the administrator endpoint to users with the `ADMIN` role.
- **Public and private endpoints:** Demonstrates different access requirements.
- **Request validation:** Validates registration usernames and passwords.
- **Global exception handling:** Returns structured JSON error responses for validation failures.
- **HTTP testing:** Uses IntelliJ HTTP Client requests to test the API.

## Endpoints

| Method | Endpoint | Access | Purpose |
|---|---|---|---|
| GET | `/api/security/public` | Public | Accessible without authentication |
| GET | `/api/security/private` | Authenticated | Requires login |
| GET | `/api/security/admin` | ADMIN role | Requires administrator authorization |
| POST | `/api/security/register` | Public | Validates a registration request |

## Configuration

The application runs on port `8083`.

The development user is configured through Spring Security properties. The password is supplied through the `DEV_USER_PASSWORD` environment variable rather than being stored directly in the application configuration.

## Run the Application

1. Install Java 21.
2. Set the `DEV_USER_PASSWORD` environment variable in your IDE's run configuration.
3. Open the project in IntelliJ IDEA.
4. Run `ApiSecurityApplication.java`.

The application starts at:

`http://localhost:8083`

## Example Registration Request

Send a `POST` request to `/api/security/register` with a JSON body:

```json
{
  "username": "johndoe",
  "password": "SecurePass123"
}
```

The example validates the registration request and returns a response. It does not create a user account or store the password.

## Validation and Error Handling

Invalid requests return HTTP `400 Bad Request` with a JSON message.

Example:

```json
{
  "message": "Username must be 3 to 30 characters"
}
```

A registration request using the reserved username `admin` returns HTTP `409 Conflict`.

## Testing

Use the included `requests.http` file in IntelliJ IDEA to test authentication, endpoint access, and registration validation.

Run the Maven tests with:

```bash
./mvnw test
```

On Windows, you can also use:

```powershell
.\mvnw.cmd test
```

## Learning Outcomes

- Configure Spring Security authentication.
- Apply role-based authorization.
- Validate incoming API requests.
- Handle validation errors consistently.
- Test secured REST endpoints.
- Manage development secrets through environment variables.

## Future Improvements

- Implement persistent user registration.
- Store passwords securely using a password encoder.
- Replace the in-memory development user with a database-backed user store.
- Add token-based authentication using JWT or OAuth 2.0.
- Add automated security integration tests.
