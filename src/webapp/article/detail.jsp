<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>

<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>▷ DETAIL</title>
</head>
<body>
<h1>게시물 상세보기</h1>
<div>번  호 : <%= (int) articleRow.get("id")%></div>
<div>날  짜 : <%= (String) articleRow.get("regDate")%></div>
<div>제  목 : <%= (String) articleRow.get("title")%></div>
<div>내  용 : <%= (String) articleRow.get("body")%></div>

<button type = "submit"> <a href = "modify?id=<%=articleRow.get("id")%>""> 글수정 </a></button>
<div><a href="list">   >> 목록보기 </a></div>



</body>
</html>