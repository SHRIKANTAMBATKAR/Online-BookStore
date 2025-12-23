<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Available Books</title>
    <link rel="stylesheet" href="css/userBooks.css">
    
</head>

<body>

<h2>📚 Available Books</h2>
<div class="search-box">
    <form action="BookServlet" method="get">
        <input type="hidden" name="action" value="search">
        <input type="hidden" name="role" value="user">

        <input type="text" name="keyword" placeholder="Search by title or author" required>
        <button type="submit">Search</button>
    </form>
</div>

<c:if test="${empty books}">
    <p class="empty">No books available</p>
</c:if>

<div class="card-container">
    <c:forEach var="b" items="${books}">
        <div class="book-card">
            <div class="book-title">${b.title}</div>
            <div class="book-author">Author: ${b.author}</div>
            <div class="book-count">Available: ${b.count}</div>            
        </div>
    </c:forEach>
</div>

<div class="back">
    <a href="BookServlet">Back to Admin</a>
</div>

</body>
</html>
