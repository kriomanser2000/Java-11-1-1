<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>NotePad</title>
</head>
<body>
<h1>Notepad list</h1>
<table border="1">
  <tr>
    <th>Company Name</th>
    <th>Notepad Name</th>
    <th>Nums of pages</th>
    <th>Cover type</th>
    <th>Country</th>
    <th>Appearance of pages</th>
  </tr>
  <c:forEach var="notebook" items="${notebooks}">
    <tr>
      <td>${notebook.manufacturer_name}</td>
      <td>${notebook.notebook_name}</td>
      <td>${notebook.page_count}</td>
      <td>${notebook.cover_type}</td>
      <td>${notebook.manufacturer_country}</td>
      <td>${notebook.page_style}</td>
    </tr>
  </c:forEach>
</table>
<h2>Add new Notepad</h2>
<form method="post" action="notebooks">
  <label>Company Name: <input type="text" name="manufacturerName" required></label><br>
  <label>Notepad Name: <input type="text" name="notebookName" required></label><br>
  <label>Nums of pages: <input type="number" name="pageCount" required></label><br>
  <label>Cover type:
    <select name="coverType" required>
      <option value="тверда">Тверда</option>
      <option value="м’яка">М’яка</option>
    </select>
  </label><br>
  <label>Country: <input type="text" name="manufacturerCountry" required></label><br>
  <label>Appearance of pages:
    <select name="pageStyle" required>
      <option value="клітинка">Cell</option>
      <option value="лінійка">Line</option>
      <option value="порожньо">Empty</option>
    </select>
  </label><br>
  <button type="submit">Add</button>
</form>
</body>
</html>