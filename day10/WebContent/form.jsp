<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록 페이지</title>
</head>
<body>

<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="id" value="${mem.mid }">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td>${mem.mid}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="글 작성하기"></td>
			</tr>
		</table>
	</form>



</body>
</html>