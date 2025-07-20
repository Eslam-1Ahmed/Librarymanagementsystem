
# 📚 Library Management System

A complete backend system for managing a digital library built using **Spring Boot 3**, **Spring Security**, **JWT**, **MySQL**, and **Spring Data JPA**.  
This project includes authentication, authorization, role-based access control, book and author management, borrowing transactions, category trees, and Swagger documentation.

---

## 🚀 Features

- 🔐 Secure login with JWT authentication.
- 👥 Role-based access (`ADMINISTRATORS`, `LIBRARIANS`, `STAFF`) using `@PreAuthorize`.
- 📦 CRUD operations for:
  - Books
  - Authors
  - Publishers
  - Categories (with parent-child relations)
  - Members
  - Users
- 📖 Book borrowing and returning system.
- 📑 Category tree with nested structure.
- 🔎 Swagger/OpenAPI documentation for all APIs.

---

## 🛠️ Technologies Used

| Tech                     | Description                       |
|--------------------------|-----------------------------------|
| Spring Boot 3.x          | Main framework                    |
| Spring Security          | Authentication & Authorization   |
| JWT (jjwt)               | Token-based authentication        |
| Spring Data JPA          | ORM & Repositories                |
| MySQL                    | Database                          |
| Lombok                  | Boilerplate code reduction        |
| Swagger (springdoc)     | API documentation (OpenAPI 3)     |

---

## 🔑 Roles

- `ADMINISTRATORS`: Full access to all modules and user management.
- `LIBRARIANS`: Manage books, categories, authors, etc.
- `STAFF`: Limited access (e.g., viewing or borrowing).

---

## 🧪 Sample Admin User

You can use the following user to log in and test:

```

Username: Eslam
Password: Eslam-1Ahmed

```

> 🔒 Password is encrypted in the database using BCrypt.

---

## 🧬 API Documentation (Swagger UI)

Once the project is running, access Swagger UI at:

```

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

```

You can test and explore all endpoints directly there.

---

## 🗂️ Project Structure

```

src
├── controller
├── service
├── entity
├── repository
├── dto
├── security
│   ├── jwt
│   └── user
├── config
└── LibraryManagementSystemApplication.java

````

---

## 🧾 How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/your-username/librarymanagementsystem.git
cd librarymanagementsystem
````

### 2. Set up the database

Create a MySQL database (e.g., `librarydb`) and ensure it's running.

### 3. Update `application.properties` or `application.yml`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the application

```bash
mvn spring-boot:run
```

---

## 🧩 Seed Data

The project includes seed data (SQL script) to insert:

* A default admin user
* Some authors, categories, books, etc.

If not auto-injected, you can manually run the script located in:

```
src/main/resources/data.sql
```

---

## 📌 Notes

* Passwords are encrypted using `BCryptPasswordEncoder`.
* JWT token must be passed as a Bearer token in the Authorization header.
* Uses `@PreAuthorize` for method-level security.

---

## 👨‍💻 Author

**Eslam Ahmed**
GitHub: [@Eslam-1Ahmed](https://github.com/Eslam-1Ahmed)
