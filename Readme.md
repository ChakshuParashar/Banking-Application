# Digital Banking System 💳

## 🚀 Features
- Create Account
- Transfer Money
- Validation Handling
- Global Exception Handling
- Swagger API Documentation

## 🛠 Tech Stack
- Java
- Spring Boot
- MySQL
- JPA
- Swagger

## 📌 API Endpoints

### Transfer Money
POST /transfer

Request:
```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 100
}