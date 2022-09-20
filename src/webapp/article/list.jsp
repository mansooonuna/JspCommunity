<%@page import = "java.util.List"%>
<%@page import = "java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
%>

<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>LIST</title>
</head>

<body>

    <h1>게시물 목록보기</h1>
    <ul>
        <%for ( Map<String, Object> articleRow : articleRows) { %>
        <li><a href="detail?id=<%=(int) articleRow.get("id")%>"><%= (int) articleRow.get("id")%>번</a>, <%= (String) articleRow.get("regDate")%>, <%= (String) articleRow.get("title")%></li>
        <% } %>
    </ul>
</body>