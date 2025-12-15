# 🛒 E-Commerce Backend Application

A simple e-commerce backend system built using **Spring Boot** and **MySQL**.  
It supports product management, cart operations, order placement, and stock validation.

This project focuses on **REST API design**, **database interactions**, and **transactional business logic**.

---

## ✨ Features

- Create and delete products  
- Add products to cart and view cart items  
- Validate product stock before placing an order  
- Place orders and calculate total amount  
- Deduct product stock on successful order  
- Global exception handling using `@RestControllerAdvice`  
- DTO-based API responses for clean separation of layers  

---

## 🛠 Tech Stack

- Java 21  
- Spring Boot  
- Spring Data JPA / Hibernate  
- MySQL  
- Maven  
- Postman (for API testing)  

---

## 📁 Project Structure

src/main/java/com/ecommerce
├── controller # REST API controllers
├── service # Business logic
├── repository # JPA repositories
├── entity # Database entities
├── dto # Data Transfer Objects
├── exception # Custom exceptions & global handler
└── mapper # Entity ↔ DTO conversion

yaml
Copy code

---

## 🚀 Setup & Run Instructions

### 1️⃣ Clone the Repository
```bash
git clone <your-github-repo-url>
cd ecommerce
2️⃣ Configure MySQL
Update src/main/resources/application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
✔ Ensure MySQL is running
✔ Create database ecommerce_db if it does not exist

3️⃣ Run the Application
bash
Copy code
mvn spring-boot:run
Or run the main Spring Boot application class from your IDE.

4️⃣ Access APIs
arduino
Copy code
http://localhost:8080
Test APIs using Postman.

🔮 Future Enhancements
Proper cart clearing after order placement

User authentication & authorization (JWT)

Role-based access (Admin / User)

Pagination & sorting

Unit and integration testing

