<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="dto.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Article article = (Article) request.getAttribute("article");
%>

<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>▷ DETAIL</title>
</head>
<body>
<h1>게시물 상세보기</h1>

<%@ include file="../part/topBar.jspf"%>
<table>
  <div>번  호 : <%= article.id%></div>
  <div>날  짜 : <%= article.regDate%></div>
  <div>수정날짜 : <%= article.updateDate%></div>
  <div>제  목 : <%= article.title%></div>
  <div>내  용 : <%= article.body%></div>
  <div>
    <a href="modify?id=${param.id}">수정</a>
    <a href="doDelete?id=${param.id}">삭제</a>
    <a href="list">리스트</a>
  </div>
</table>
</body>
</html>