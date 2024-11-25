<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Manufacturer Counts</h1>
<table border="1">
  <tr>
    <th>Manufacturer</th>
    <th>Notebook Count</th>
  </tr>
  <c:forEach var="count" items="${manufacturerCounts}">
    <tr>
      <td>${count.manufacturer_name}</td>
      <td>${count.count}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
