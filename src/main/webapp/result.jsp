<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result</h1>
<table border="1">
  <tr>
    <th>Attribute</th>
    <th>Count</th>
  </tr>
  <c:forEach var="row" items="${result}">
    <tr>
      <td>${row.manufacturer_country != null ? row.manufacturer_country : row.manufacturer_name}</td>
      <td>${row.count}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
