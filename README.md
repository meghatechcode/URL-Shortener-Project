# URL-Shortener-Project
A simple URL shortening service built using **Java**, **Spring Boot**, and **MySQL**.

## 🚀 Features
- Shorten long URLs using Base62 encoding
- Redirect short URLs to the original URL
- Track access count and creation timestamp
- RESTful APIs with JSON responses

## 🛠 Tech Stack
- Java 17
- Spring Boot 3
- Spring Web & Spring Data JPA
- MySQL
- Maven
- JUnit & Mockito

## 📦 Setup
```bash
mvn clean install
mvn spring-boot:run
```

## 🔗 API Endpoints
📌 POST /shorten
Purpose: Generate a short URL from a long URL.
Request Body (raw text): https://example.com/very-long-url
Response: http://localhost:8080/abc123
📌 GET /{shortCode}
Purpose: Redirects to the original long URL using the short code.
Example: GET http://localhost:8080/abc123
Redirects To: https://example.com/very-long-url


## 👤 Author
Megha Rathi
