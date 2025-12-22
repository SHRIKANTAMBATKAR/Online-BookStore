<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/addbook.css">

</head>
<body>
<form action="BookServlet" method="post" class="form-card">

    <h2>Add More New Book</h2>

    <input type="hidden" name="action" value="add">

    <div class="form-group">
        <label>Title</label>
        <input type="text" name="title" required>
    </div>

    <div class="form-group">
        <label>Author</label>
        <input type="text" name="author" required>
    </div>

    <div class="form-group">
        <label>Count</label>
        <input type="number" name="count" required>
    </div>

    <button class="submit-btn">Add Book</button>

    <a href="BookServlet" class="back-link">← Back to Book List</a>
</form>
</body>

</html>
