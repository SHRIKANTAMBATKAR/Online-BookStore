<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">

<h2>Online Book Store</h2>


<a href="addBook.jsp" class="add-btn">Add Book</a>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Count</th>
        <th>Action</th>
    </tr>

    <c:forEach var="b" items="${books}">
        <tr>
            <td>${b.id}</td>
            <td>${b.title}</td>
            <td>${b.author}</td>
            <td>${b.count}</td>
            <td>
                <a class="action-btn" href="BookServlet?action=edit&id=${b.id}">Edit</a> |
                <a class="action-btn" href="BookServlet?action=delete&id=${b.id}"
                   onclick="return confirm('Delete book?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${empty books}">
    <h3 style="color:red">No books found</h3>
</c:if>
