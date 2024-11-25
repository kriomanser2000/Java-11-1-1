<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Countries</h1>
<ul>
  <c:forEach var="country" items="${countries}">
    <li>${country.manufacturer_country}</li>
  </c:forEach>
</ul>
</body>
</html>
