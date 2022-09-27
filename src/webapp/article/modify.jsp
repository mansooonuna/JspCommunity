<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>

<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>▷ MODIFY </title>
</head>
<body>
<h1>게시물 수정</h1>

<form action="doModify" method = "POST">
  <input autocomplete="off" type="hidden" name = "id" value="${param.id}">

  <div>번  호 : <%= (int) articleRow.get("id")%></div>
  <div>날  짜 : <%= (String) articleRow.get("regDate")%></div>
  <div>제  목 : <input type="text" name="title" placeholder="제목을 입력해주세요." value="<%= (String) articleRow.get("title")%>"></div>
  <div>내  용 : <textarea name="body" placeholder="내용을 입력해주세요."><%= (String) articleRow.get("body")%></textarea></div>
  <div>
    <button type="submit">수정</button>
    <a href="list"> >> 목록보기</a>
  </div>
</form>

</body>
</html>