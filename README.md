# Hibernate CRUD Application – Employees & Courses Management

## 📌 Project Description

This project was developed as part of a university assignment focused on the Hibernate framework. The application manages employees and their associated courses using a relational database and ORM (Object-Relational Mapping) techniques.

The system is implemented as a Java application (console/Swing-based) and performs full CRUD operations using Hibernate and annotations.

---

## 🛠 Technologies Used

* Java
* Hibernate ORM (Annotations)
* MySQL
* Eclipse IDE

---

## 🗄 Database Design

The application uses two main tables:

### Employees

* `id` (Primary Key)
* `name`
* `firm`
* `position`
* `date_of_employment`

### Courses

* `id_course` (Primary Key)
* `id_employee` (Foreign Key)
* `name`
* `number_of_hours`
* `value`
* `graduation_diploma` (Y/N)
* `year`

📌 Relationship:

* One-to-Many → One employee can have multiple courses

---

## ⚙️ Functional Requirements (Implemented Features)

### Employee Management

* Add a new employee
* Update employee data
* Delete an employee
* Search for an employee

### Course Management

* Add a course
* Update course details
* Delete a course
* Search for a course

### Advanced Queries

* Display all employees from a specific company
* Display employees with employment duration greater than a given value
* Display employees who attended a specific course

---

## 🧠 Key Concepts Used

* Hibernate Session & SessionFactory
* Entity mapping using annotations
* One-to-Many relationship mapping
* CRUD operations with Hibernate
* Basic query handling

---

## 🚀 How to Run the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/SorinNicola7/Hibernate-CRUD.git
   ```

2. Configure the database:

   * Create a MySQL database
   * Update `hibernate.cfg.xml` with your credentials

3. Run the application:

   * Open the project in Eclipse
   * Run the main class

---

## 📚 What I Learned

* How to use Hibernate for database interaction
* How to map Java objects to relational tables
* Implementing CRUD operations in a structured way
* Working with relational data and entity relationships
* Writing queries for specific data filtering

---

## 🔧 Possible Improvements

* Convert the project to Maven/Gradle
* Add layered architecture (DAO, Service)
* Implement a REST API using Spring Boot
* Add a web interface instead of console/Swing
* Improve validation and error handling

---

## 📎 Notes

This project was developed based on academic requirements and demonstrates core Hibernate functionalities. It represents a foundational step towards building more advanced backend applications.

---
