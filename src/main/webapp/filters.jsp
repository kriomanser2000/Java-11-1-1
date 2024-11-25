<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Filter Notebooks</h1>
<form action="/notebooks" method="get">
  <input type="hidden" name="action" value="notebooksByCountry">
  <label for="country">Country:</label>
  <input type="text" id="country" name="country" required>
  <button type="submit">Filter by Country</button>
</form>
<form action="/notebooks" method="get">
  <input type="hidden" name="action" value="filterByPageStyle">
  <label for="pageStyle">Page Style:</label>
  <select id="pageStyle" name="pageStyle" required>
    <option value="Lined">Lined</option>
    <option value="Plain">Plain</option>
    <option value="Graph">Graph</option>
  </select>
  <button type="submit">Filter by Page Style</button>
</form>
<form action="/notebooks" method="get">
  <input type="hidden" name="action" value="filterByPageCount">
  <label for="minPages">Min Pages:</label>
  <input type="number" id="minPages" name="minPages" required>
  <label for="maxPages">Max Pages:</label>
  <input type="number" id="maxPages" name="maxPages" required>
  <button type="submit">Filter by Page Count</button>
</form>
</body>
</html>
