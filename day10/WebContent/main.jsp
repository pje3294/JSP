<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.board.*"%>


<!-- 로그인, 로그아웃 커스텀 태그 -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>

<!-- jstl사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

	<!-- 설계 
	- 작성자 검색 
	- 게시물 전체 목록 보이도록(샘플 데이터) - 글번호, 제목, 내용 전체 
	- login / logout  : 로그인 상태에만 로그아웃 보이도록 
	- 마이페이지 : 로그인 시에만 보이도록 => 클릭 시, myPage.jsp로 이동 
 -->



	<!-- 검색화면 -->

	<h2>검색</h2>
	<hr>
	<form method="post" name="searchBox" action="control.jsp" name="form1">
		<input type="hidden" name="action" value="searching"> <select
			name="condition">
			<option selected value="id">작성자</option>
			<option value="title">제목</option>
		</select> <input type="text" name="content"> <input type="submit"
			value="검색하기">
	</form>
	<hr>



	<!-- 첫페이지는 전체 게시물  || 검색 시, 검색결과  -->
	
	<h2>게시물 목록</h2>
	<hr>
	<br>
	<table border="1">
		<tr>
			<th>no.</th>
			<th>title</th>
			<th>content</th>
			<th>id</th>
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

	<c:if test="${not empty datas}">
		<!-- for문 -> JSTL-core 사용 -->
		<c:forEach var="v" items="${datas}">
			<tr>
				<td>${v.bnum}</td>
				<td>${v.title}</td>
				<td>${v.content}</td>
				<td>${v.id}</td>
			</tr>
		</c:forEach>
	</c:if>

		<%-- <%
			}
		%> --%>
	</table>
	<br>
	<hr>
	<br>



	<!-- 로그인, 로그아웃, 마이페이지이동  -->
	
	<h2>로그인/로그아웃</h2>
	<hr>
	<br>
	<%-- 	<%
		if (session.getAttribute("mem") == null) {
	%> --%>


	<!-- jstl-core if 사용 -->
	<c:if test="${empty mem }">

		<!-- 로그인 커스텀태그 -->
		<mytag:login border="3" />

	</c:if>


	<%-- 	<%
		} else {
	%> --%>

	<!-- jstl에는 else 존재하지 않음-> if문 기입 -->
	<c:if test="${not empty mem }">
		<!-- 로그아웃 커스텀태그 -->
		<mytag:logout />

	</c:if>

	<%-- 	<%
		}
	%> --%>

</body>
</html>