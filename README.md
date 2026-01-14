# 📚 Online Book Store Management System

A Java-based **Online Book Store Management System** developed using **JSP, Servlets, JDBC, and MySQL**.  
The application follows the **MVC (Model–View–Controller)** architecture and supports complete **CRUD operations** for managing book records.

---

## 📌 Project Overview

This web application is designed to digitally manage book records for libraries, colleges, or small institutions.  
It replaces manual record-keeping with a **database-driven system**, improving accuracy, efficiency, and data consistency.

---

## 🎯 Objectives

- Efficiently manage book records  
- Implement MVC architecture in a Java web application  
- Perform CRUD operations using JDBC  
- Understand real-world Java web development workflow  

---

## 🚀 Features

### 📖 Book Management
- Add new books  
- Update existing book details  
- Delete books  
- View all books in a tabular format  

### ⚙️ Functional Highlights
- Servlet-based controller logic  
- JSP with JSTL for dynamic UI rendering  
- Secure database operations using `PreparedStatement`  
- Clean and user-friendly admin interface  

---

## 🛠️ Technology Stack

| Layer      | Technology                     |
|------------|--------------------------------|
| Frontend   | JSP, HTML, CSS                 |
| Backend    | Java, Servlets, JDBC           |
| Database   | MySQL                          |
| Server     | Apache Tomcat                  |

---

## 🧱 Architecture (MVC)

### Model
- `Book.java` – Represents the book entity  
- `BookDAO.java` – Handles all database operations  

### View
- `listBooks.jsp`  
- `addBook.jsp`  
- `editBook.jsp`  

### Controller
- `BookServlet.java` – Handles HTTP requests and controls application flow  

---

## 🔄 Application Workflow

1. User interacts with JSP pages  
2. Request is sent to `BookServlet`  
3. Servlet determines action using request parameters  
4. DAO performs database operations using JDBC  
5. Response is forwarded back to JSP  
6. JSP displays updated data to the user  

---

## ▶️ How to Run the Project

1. Clone the repository  
   git clone https://github.com/SHRIKANTAMBATKAR/Online-BookStore.git
2. Open the project in Eclipse IDE

3. Add and configure Apache Tomcat Server

4. Create a MySQL database and required table

5. Update database credentials in BookDAO.java

6. Run the project on the server

## 🔐 Security & Validation

- Uses POST method for form submission
- Uses PreparedStatement to prevent SQL injection
- Delete operation includes a confirmation prompt

## 📚 Learning Outcomes

- Practical understanding of JSP and Servlets
- JDBC-based database connectivity and handling
- MVC architecture implementation
- Web application request–response lifecycle
- UI design for admin-based systems

## 🚧 Future Enhancements

- User authentication and authorization
- Book search and filtering
- Pagination for large datasets
- Book issue and return module
- REST API implementation

🧑‍💻 Author

Shrikant Ambatkar </BR> 
Java & Web Development Enthusiast

