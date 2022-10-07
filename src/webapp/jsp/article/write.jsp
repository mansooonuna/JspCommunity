<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>▷ WRITE </title>
</head>
<body>
<h1>게시물 작성하기</h1>

<form action = "doWrite" method = "POST">
     <input type="hidden" name="redirectUri" value="../article/detail?id=[NEW_ID]">
  <div>제  목 : <input autocapitalize="off" placeholder="제목을 입력해주세요." name = "title" type="text"/> </div>
  <div>내  용 : <textarea autocapitalize="off" placeholder="내용을 입력해주세요." name = "body"> </textarea></div>
  <div>
    <button type = "submit"> 작성 </button>
    <a href="list"> 리스트로 돌아가기</a>
  </div>
</form>

</body>
</html>