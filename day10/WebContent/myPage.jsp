<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, model.board.*, model.member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- jstl사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="memberVO" class="model.member.MemberVO" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<!-- (control 통해)edit.jsp로 이동하기위해 ==> BoardDAO update 수정 시, 
bnum필요하기 때문에 -->
<script type="text/javascript">
	function goEdit(bnum) {
		document.location.href = "control.jsp?action=edit&bnum=" + bnum;
	}
</script>



</head>
<body>

	<%-- <h2><%=((MemberVO) session.getAttribute("mem")).getMid()%>님,
		환영합니다(❁´◡`❁)
	</h2> --%>

	<h2>${mem.mid }님,환영합니다(❁´◡`❁)</h2>

	<hr>
	<br>
	<h3>게시글 목록</h3>
	<table border="1">
		<tr>
			<th>no.</th>
			<th>title</th>
			<th>content</th>
			<th>date</th>
		</tr>

		<%-- <%
			if (datas.size() == 0) {
				out.println("<tr><td colspan='3'>등록된 글 없음.</td></tr>");
			} else {
		%> --%>

		<c:if test="${empty datas }">
			<tr>
				<td colspan='3'>등록된 글 없음.</td>
			</tr>
		</c:if>

	<c:if test="${not empty datas }">
		<!-- for문 -> JSTL-core 사용 -->
		<c:forEach var="v" items="${datas}">
			<!-- for(String v : 집합명)    -> items : 집합명 -->
			<tr>
				<td><a href="javascript:goEdit(${v.bnum })">${v.bnum}</a></td>
				<td>${v.title }</td>
				<td>${v.content }</td>
				<td>${v.bdate}</td>
			</tr>
		</c:forEach>
	</c:if>


		<%-- <%
			}
		%> --%>
	</table>

	<br>
	<a href="form.jsp">새글 쓰기</a>
	<br>
	<br>
	<a href="control.jsp?action=main">메인으로 돌아가기</a>


</body>
</html>