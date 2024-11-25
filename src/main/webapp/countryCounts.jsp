<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Country Counts</h1>
<table border="1">
  <tr>
    <th>Country</th>
    <th>Notebook Count</th>
  </tr>
  <c:forEach var="count" items="${countryCounts}">
    <tr>
      <td>${count.manufacturer_country}</td>
      <td>${count.count}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
