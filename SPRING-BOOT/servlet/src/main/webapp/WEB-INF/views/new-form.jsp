<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
 <meta charset="UTF-8">
 <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
 <p> username: <input type="text" name="username" />
 <p> age: <input type="text" name="age" />
 <button type="submit">전송</button>
</form>
</body>
</html>