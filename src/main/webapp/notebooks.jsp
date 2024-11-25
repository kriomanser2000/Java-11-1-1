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
<h1>Notebook List</h1>
<table border="1">
  <tr>
    <th>Company Name</th>
    <th>Notebook Name</th>
    <th>Page Count</th>
    <th>Cover Type</th>
    <th>Country</th>
    <th>Page Style</th>
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
</body>
</html>