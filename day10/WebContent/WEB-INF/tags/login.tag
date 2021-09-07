<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<!--속성 부여  -->
<%@ attribute name="border" %>

<form method="post" name="form2" action="control.jsp" >
<input type="hidden" name="action" value="login">
<table border="${border }">
<tr>
	<td>아이디</td>
	<td><input type="text" name="mid"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="mpw"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="로그인"></td>
</tr>
</table>
</form>

