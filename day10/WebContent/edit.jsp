<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<jsp:useBean id="data" class="model.board.BoardVO" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정/삭제 페이지</title>
<script type="text/javascript">
	function del() {
		check = confirm("해당 글을 영구적으로 삭제하시겠습니까?");
		if (check == true) {
			document.form1.action.value = "delete";
			document.form1.submit();
		} else {
			return;
		}
	}
</script>

</head>
<body>
<!--원래버전  -->
	<%-- <h2>글 수정/삭제하기</h2>
	<h3><%=data.getId()%>님이
		<%=data.getBdate()%>에 작성한 글입니다.
	</h3> --%>
	
	<h2>글 수정/삭제하기</h2>
	<h3>"${mem.mid }"님이  작성한 글입니다.</h3>
	
	<br>
	<hr>

	<form action="control.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="update"> 
		<input type="hidden" name="bnum" value="${data.bnum}"> 
		<input type="hidden" name="id" value="${data.id}">

		<table border="1">
			<tr>
				<td>title</td>
				<td><input type="text" name="title"
					value="${data.title}"></td>
			</tr>
			<tr>
				<td>content</td>
				<td><input type="text" name="content"
					value="${data.content}"></td>
			</tr>
			<tr>
				<td>date</td>
				<td><input type="date" name="bdate"
					value="${data.bdate}" disabled></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정하기"> <input
					type="button" value="삭제하기" onClick="del()"></td>
			</tr>
		</table>

	</form>

	<br>
	<br>
	<a href="control.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>