# 🧾 Cards Microservice

This is a Spring Boot-based microservice that manages card operations such as creating, fetching, updating, and deleting card details based on mobile number input.

## 📦 Features

- Create new card
- Fetch card details
- Update card details
- Delete card details
- Input validation (mobile number)
- Structured API responses
- Swagger OpenAPI documentation

---

## 🚀 API Endpoints

All endpoints are under the `/api` path.

### 1. ➕ Create Card

- **URL:** `POST /api/create`
- **Request Param:** `mobileNumber` (must be 10 digits)
- **Response:** 201 CREATED

### 2. 📄 Fetch Card Details

- **URL:** `GET /api/fetch`
- **Request Param:** `mobileNumber` (must be 10 digits)
- **Response:** 200 OK with card details

### 3. 🔄 Update Card

- **URL:** `PUT /api/update`
- **Request Body:** JSON object of card data
- **Response:** 
  - 200 OK if successful
  - 417 Expectation Failed if update fails

### 4. ❌ Delete Card

- **URL:** `DELETE /api/delete`
- **Request Param:** `mobileNumber` (must be 10 digits)
- **Response:**
  - 200 OK if deleted
  - 417 Expectation Failed if not found/deleted

---

## 📚 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Lombok
- Jakarta Validation
- Swagger/OpenAPI 3

---

## 🧪 Example Curl Commands

```bash
# Create a card
curl -X POST "http://localhost:8080/api/create?mobileNumber=1234567890"

# Fetch card
curl -X GET "http://localhost:8080/api/fetch?mobileNumber=1234567890"

# Update card
curl -X PUT "http://localhost:8080/api/update" \
     -H "Content-Type: application/json" \
     -d '{ "cardNumber": "1234-5678-9876-5432", "mobileNumber": "1234567890", ... }'

# Delete card
curl -X DELETE "http://localhost:8080/api/delete?mobileNumber=1234567890"
