<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Notebook</h1>
<form action="/notebooks" method="post">
  <input type="hidden" name="action" value="deleteNotebook">
  <label for="id">Notebook ID:</label>
  <input type="number" id="id" name="id" required><br>
  <button type="submit">Delete Notebook</button>
</form>
</body>
</html>
