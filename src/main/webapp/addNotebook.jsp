<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Notebook</h1>
<form action="/notebooks" method="post">
  <input type="hidden" name="action" value="addNotebook">
  <label for="manufacturer_name">Manufacturer Name:</label>
  <input type="text" id="manufacturer_name" name="manufacturer_name" required><br>
  <label for="notebook_name">Notebook Name:</label>
  <input type="text" id="notebook_name" name="notebook_name" required><br>
  <label for="page_count">Page Count:</label>
  <input type="number" id="page_count" name="page_count" required><br>
  <label for="cover_type">Cover Type:</label>
  <input type="text" id="cover_type" name="cover_type" required><br>
  <label for="manufacturer_country">Manufacturer Country:</label>
  <input type="text" id="manufacturer_country" name="manufacturer_country" required><br>
  <label for="page_style">Page Style:</label>
  <input type="text" id="page_style" name="page_style" required><br>
  <button type="submit">Add Notebook</button>
</form>
</body>
</html>
