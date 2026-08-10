# Mobile Phone Distribution Management System

A web-based **Mobile Phone Distribution Management System** developed using **Java, Spring Boot, Spring Data JPA, Thymeleaf, and Oracle Database**.

The system helps manage mobile phones, executives, phone assignments, and waiting-list operations through a centralized web application.

## 🚀 Features

* Executive management
* Mobile phone management
* Phone assignment to executives
* Automatic phone assignment
* Manual phone assignment
* Waiting-list management
* Assignment history
* Dashboard for monitoring system activities
* Form validation
* Database persistence using JPA/Hibernate

## 🛠️ Technologies Used

| Technology      | Usage                          |
| --------------- | ------------------------------ |
| Java 17         | Backend development            |
| Spring Boot     | Application framework          |
| Spring MVC      | Web application architecture   |
| Spring Data JPA | Database operations            |
| Hibernate       | ORM                            |
| Thymeleaf       | Frontend/server-side templates |
| Oracle Database | Database                       |
| Maven           | Build & dependency management  |
| HTML/CSS        | User interface                 |
| Eclipse         | Development IDE                |

## 📂 Project Structure

```text
MobilePhoneDistributionManagementSystem
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.mobile
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.properties
│   │
│   └── test
│
├── .gitignore
├── .gitattributes
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## ⚙️ Prerequisites

Before running the application, install:

* Java 17 or later
* Maven
* Oracle Database
* Eclipse/IntelliJ IDEA/STS

## 🔧 Configuration

Update the database configuration in:

```text
src/main/resources/application.properties
```

Configure your Oracle database username, password, URL, and other required properties.

> **Security:** Do not commit real database passwords or other sensitive credentials to GitHub.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/rutvikraut15/MobilePhoneDistributionManagementSystem.git
```

### 2. Open the project

Import the project as a **Maven Project** in Eclipse, Spring Tool Suite, or IntelliJ IDEA.

### 3. Configure Oracle Database

Create/configure the required Oracle database and update the database properties.

### 4. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Alternatively, run the Spring Boot main application class directly from your IDE.

## 📌 Main Modules

### Dashboard

Provides an overview of the system.

### Executive Management

Manages executives and their availability/presence status.

### Phone Management

Manages mobile phone records and their availability.

### Assignment Management

Assigns available mobile phones to executives.

### Waiting List

Maintains executives waiting when a phone is unavailable.

### Assignment History

Provides information about previous assignments.

## 🔄 Assignment Flow

```text
Executive
    ↓
Check Executive Availability
    ↓
Check Available Phones
    ↓
 ┌───────────────────┐
 │ Phone Available?  │
 └─────────┬─────────┘
       Yes │ No
           │
     Assign Phone
           │
     Update Status
           │
     Save Assignment

If No Phone Available
           ↓
      Waiting List
```

## 📚 Spring Boot Dependencies

The project uses Spring Boot dependencies for:

* Spring Data JPA
* Spring Web MVC
* Thymeleaf
* Validation
* Oracle JDBC
* Lombok

## 👨‍💻 Author

**Rutvik Raut**

Java Full Stack Developer
