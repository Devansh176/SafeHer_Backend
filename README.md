# 🚨 SafeHer Backend - Spring Boot

The **SafeHer** backend is a secure, RESTful Spring Boot service powering the SafeHer mobile app. It enables real-time emergency response features, such as user authentication, emergency contact management, location sharing, and communication with Firebase and PostgreSQL.

---

## ✅ Features

- 🔐 User registration and login using Firebase
- 📞 Emergency contact CRUD operations
- 📍 Real-time location sharing via API
- 🧾 PostgreSQL data storage with JPA
- 🔧 Clean layered architecture (Controller → Service → Repository)
- 🔒 Secured endpoints using Spring Security
- 🧪 Test cases for services and controllers

---

## 🏗️ Project Structure

src/
├── main/
│ ├── java/com/example/SafeHer/
│ │ ├── config/ # Security & app configs (Firebase, JWT, etc.)
│ │ ├── controller/ # REST API controllers (auth, contacts, location)
│ │ ├── entity/ # JPA entity classes for User, Contact, etc.
│ │ ├── payload/ # DTOs (requests, responses, wrappers)
│ │ ├── repository/ # JPA Repositories for database access
│ │ └── service/ # Core business logic
│ └── resources/
│ └── application.properties # Spring Boot app configuration
├── test/java/com/example/SafeHer/ # Unit & integration tests
├── pom.xml # Maven project file

yaml
Copy
Edit

---

## ⚙️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security
- Firebase Admin SDK
- PostgreSQL
- Hibernate/JPA
- Maven
- Lombok
- JUnit

---

## 🔧 Getting Started

### 🔗 Prerequisites

- Java 17 or later
- Maven
- PostgreSQL running locally
- Firebase project with Admin SDK JSON

### ⚙️ Setup Instructions

1. **Clone the Repository**

```bash
git clone https://github.com/your-username/safeher-backend.git
cd safeher-backend
Configure application.properties

Edit src/main/resources/application.properties:

properties

# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/safeher_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

# Hibernate
spring.jpa.hibernate.ddl-auto=update

# Firebase Admin SDK path
firebase.config.path=src/main/resources/firebase-adminsdk.json
Build and Run

./mvnw clean install
./mvnw spring-boot:run
📡 API Endpoints Overview
🔐 Auth (Firebase)
POST /api/auth/login
→ Authenticates a user using Firebase token.

POST /api/auth/register
→ Registers user by saving Firebase UID and user details.

📞 Emergency Contacts
GET /api/contacts
→ Returns current user’s saved emergency contacts.

POST /api/contacts
→ Adds a new emergency contact.

DELETE /api/contacts/{id}
→ Removes a specific emergency contact.

📍 Location
POST /api/location/share
→ Shares current location with selected emergency contacts via SMS or notification.

🧪 Running Tests
./mvnw test


🙋 Contributing
Fork the repo

Create a new feature branch (git checkout -b feature/feature-name)

Commit your changes (git commit -am 'Add new feature')

Push to the branch (git push origin feature/feature-name)

Open a pull request 🎉

📬 Contact
Devansh Dhopte
📧 your-devanshdhopte@gmai.com
GitHub: /Devansh176

💡 Future Improvements
Docker and CI/CD setup

Admin panel for emergency monitoring

Firebase Cloud Messaging (FCM) integration

Enhanced geofencing logic for unsafe area alerts


