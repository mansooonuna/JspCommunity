<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
boolean isLogined = (boolean) request.getAttribute("isLogined");
int loginedMemberId = (int) request.getAttribute("loginedMemberId");
%>


<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>▷ Main</title>
</head>
<body>
  <h1>Main</h1>

  <% if ( isLogined ) { %>
    <div>
      로그인 되었습니다.
      　
      <a href="../member/doLogout">로그아웃</a>
    </div>
  <% } %>

  <% if ( !isLogined ) { %>
    <div>
      <a href="../member/join">회원가입</a>
      <a href="../member/login">로그인</a>
    </div>
  <% } %>

  <div>
    <a href="../article/list">게시물 리스트</a>
  </div>


</body>