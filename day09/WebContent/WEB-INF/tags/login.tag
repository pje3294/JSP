<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>



<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="login">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw"></td>
		</tr>
		<tr>
			<td colspan='2'><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>