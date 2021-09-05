<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memVO" class="model.member.MemberVO"/>
<jsp:setProperty property="*" name="memVO"/>
<jsp:useBean id="memDAO" class="model.member.MemberDAO"/>


<%
	String action = request.getParameter("action");

	if(action.equals("login")){
		MemberVO mem = memDAO.getData(memVO);
		if(mem != null){ 
	session.setAttribute("mem", request.getParameter("mid"));
	pageContext.forward("view.jsp");
		}
	}else if(action.equals("logout")){
		session.invalidate();
		pageContext.forward("view.jsp");
	}
%>