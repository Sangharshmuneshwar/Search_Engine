<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Accio.historyResult"%>

<html>
<head>
<link rel = "stylesheet" type ="text/css" href = "style.css"/>
</head>
<body>
<h1>Search Engine</h1>
<form action = "Search">
<input type = "text" name = "Keyword"></input>
<button type = "submit">Search</button>
</form>

<form action = "History">

<button type = "submit">History</button>
</form>
<table border = 2 class = "tableDesplay">
<tr>
<th>Keyword</th>
<th>link</th>
</tr>
<%
ArrayList<historyResult> results = (ArrayList<historyResult>)request.getAttribute("results");
for(historyResult result : results){
%>

<tr>
    <td><%out.println(result.getKeyword());%></td>
    <td><a href = "<%out.println(result.getLink());%>"><%out.println(result.getLink());%><a></td>
</tr>

    <%
    }
    %>
</table>
</body>
</html>