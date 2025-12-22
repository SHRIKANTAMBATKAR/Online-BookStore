# 📚 Online Book Store Management System

A Java-based Online Book Store Management System developed using JSP, Servlets, JDBC, and MySQL.
The project follows the MVC (Model–View–Controller) architecture and performs complete CRUD operations for managing books.

📌 Project Overview

This application is designed to digitally manage book records for libraries, colleges, or small institutions.
It replaces manual record keeping with a database-driven web application, improving accuracy and efficiency.

🎯 Objectives

To manage book records efficiently

To implement MVC architecture in a Java web application

To perform CRUD operations using JDBC

To understand real-world Java web development workflow

🚀 Features

📖 Book Management
   
ㅤAdd new books

ㅤUpdate existing book details

ㅤDelete books

ㅤView all books in tabular format

⚙️ Functional Highlights

ㅤServlet-based controller

ㅤJSP with JSTL for dynamic UI

ㅤSecure database operations using PreparedStatement

ㅤClean and user-friendly admin interface

🛠️ Technology Stack

Layer	  ㅤㅤㅤTechnology

Frontend	ㅤㅤJSP, HTML, CSS

Backend	ㅤㅤ Java, Servlets ,JDBC

Databaseㅤㅤ	MySQL

Serverㅤㅤㅤ	Apache Tomcat

🧱 Architecture (MVC)
Model

Book.java – Represents book data

BookDAO.java – Handles all database operations

View

listBooks.jsp

addBook.jsp

editBook.jsp

Controller

BookServlet.java – Handles requests and controls flow


🔄 Application Workflow

User interacts with JSP pages

Request goes to BookServlet

Servlet decides action based on request parameter

DAO performs database operation using JDBC

Response is sent back to JSP

JSP displays updated data to the user



▶️ How to Run the Project

Clone the repository

git clone https://github.com/SHRIKANTAMBATKAR/OnlineBookStore.git

Open the project in Eclipse IDE

Add Apache Tomcat Server

Create MySQL database and table

Update database credentials in BookDAO.java

Run project on server

Access in browser:

http://localhost:8080/OnlineBookStore/BookServlet

🔐 Security & Validation

Uses POST method for form submission

Uses PreparedStatement to prevent SQL injection

Delete operation includes confirmation prompt

📚 Learning Outcomes

Practical understanding of JSP and Servlets

JDBC connection and database handling

MVC architecture implementation

Web application request–response cycle

UI design for admin systems

🚧 Future Enhancements

User authentication and authorization

Book search and filter

Pagination for large records

Book issue and return module

REST API implementation

🧑‍💻 Author

Shrikant Ambatkar
Java & Web Development Enthusiast

⭐ Support

If you like this project, please consider giving it a ⭐ on GitHub.

