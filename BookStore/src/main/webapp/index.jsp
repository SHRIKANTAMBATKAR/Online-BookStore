<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="css/index.css">

<h2>Online Book Store</h2>

<form action="BookServlet" method="get" class="search-form">
    <input type="hidden" name="action" value="search">
    <input type="hidden" name="role" value="admin">

    <input type="text" name="keyword" placeholder="Search by title or author" required>
    <button type="submit">Search</button>
</form>

<br>

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

                <!-- ISSUE BOOK -->
                <c:if test="${b.count > 0}">
                    <a class="action-btn"
                       href="BookServlet?action=issue&id=${b.id}"
                       onclick="return confirm('Issue this book?')">
                        Issue
                    </a> |
                </c:if>

                <!-- DELETE ONLY WHEN COUNT = 0 -->
                <c:if test="${b.count == 0}">
                    <a class="action-btn"
                       href="BookServlet?action=delete&id=${b.id}"
                       onclick="return confirm('Delete book?')">
                        Delete
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<a href="BookServlet?action=userView" class="add-btn">
    Go to User View
</a>

