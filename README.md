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

```
src/
├── main/
│   ├── java/com/example/SafeHer/
│   │   ├── config/         → Security & Firebase configurations
│   │   ├── controller/     → API endpoints for auth, contacts, location
│   │   ├── entity/         → JPA entity models (User, Contact, etc.)
│   │   ├── payload/        → DTOs and request/response wrappers
│   │   ├── repository/     → JPA repositories (UserRepository, etc.)
│   │   └── service/        → Business logic layer
│   └── resources/
│       └── application.properties → Environment & database configs
├── test/java/com/example/SafeHer/ → Unit & integration tests

Other files:
- pom.xml
- .gitignore
- .gitattributes
- bfg.jar
- mvnw, mvnw.cmd
```

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
```

2. **Configure `application.properties`**
Edit `src/main/resources/application.properties`:

```properties
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/safeher_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

# Hibernate
spring.jpa.hibernate.ddl-auto=update

# Firebase Admin SDK path
firebase.config.path=src/main/resources/firebase-adminsdk.json
```

3. **Build and Run**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 📡 API Endpoints Overview

### 🔐 Auth (Firebase)
- `POST /api/auth/login` → Authenticates user via Firebase token
- `POST /api/auth/register` → Registers a new user

### 📞 Emergency Contacts
- `GET /api/contacts` → Fetch the user’s emergency contacts
- `POST /api/contacts` → Add a new contact
- `DELETE /api/contacts/{id}` → Remove contact

### 📍 Location
- `POST /api/location/share` → Share current location with selected contacts

---

## 🧪 Running Tests

```bash
./mvnw test
```


## 🙋 Contributing

1. Fork the repo
2. Create a new branch (`git checkout -b feature/feature-name`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Create a Pull Request 🎉

---

## 📬 Contact

**Devansh Dhopte**  
📧 your-devanshdhopte@gmail.com  
GitHub: [@Devansh176](https://github.com/Devansh176)

---

## 💡 Future Improvements

- Docker and CI/CD setup
- Admin panel for monitoring alerts
- Firebase Cloud Messaging (FCM)
- Smart geofencing & path learning
