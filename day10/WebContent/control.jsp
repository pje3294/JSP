<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.*, model.board.*, java.util.*" errorPage="error.jsp"%>
   <%request.setCharacterEncoding("UTF-8"); %> 
    
    <jsp:useBean id="boardDAO" class="model.board.BoardDAO"/>
    <jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
    <jsp:useBean id="memberVO" class="model.member.MemberVO"/>
    <jsp:setProperty property="*" name="memberVO"/>
    <jsp:useBean id="boardVO" class="model.board.BoardVO" scope="session"/>
    <jsp:setProperty property="*" name="boardVO"/>
    
<%

//System.out.println("확인!"+memberVO);

	// view에서 액션 가져오기
	String action = request.getParameter("action");

	// 검색어 가져오기
	String condition = request.getParameter("condition");
	String content = request.getParameter("content");
	
	/* 
	String id = session.getId();  */


	if(action.equals("main")){
		System.out.println("main액션 실행 로그");
		ArrayList<BoardVO> datas = boardDAO.selectAll();
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
		
		
	}else if(action.equals("searching")){
		System.out.println("searching액션 실행 로그");
		ArrayList<BoardVO> datas = boardDAO.search(condition, content);
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
		
		
	}else if(action.equals("login")){
		System.out.println("login액션 실행 로그");
		MemberVO mem = memberDAO.selectOne(memberVO);
		System.out.println(mem); // 로깅
		if(mem != null){
			session.setAttribute("mem", mem);
			// 로그인  성공 --> session에 "mem"이랑 MemberVo 객체 설정 
			response.sendRedirect("control.jsp?action=main");
		}else{
			out.println("<script>alert('등록된 회원이 아닙니다! 확인해주세요.');history.go(-1)</script>");
		}
		
		
	}else if(action.equals("logout")){
		System.out.println("logout액션 실행 로그");
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	
		
		
	}else if(action.equals("my")){
		System.out.println("my액션 실행 로그");
		String myID = ((MemberVO)session.getAttribute("mem")).getMid();
		// MemberVO 객체의 getmid를 하기 위해서  (로그인 회원에 맞게 마이페이지 제공해야함으로)
		//String myID = (String)session.getAttribute("mid"); -> xxx
		System.out.println(myID); //로깅
		ArrayList<BoardVO> datas = boardDAO.selectAllmy(myID);  
		request.setAttribute("datas", datas);
		pageContext.forward("myPage.jsp");
	
	
	}else if(action.equals("edit")){
		System.out.println("edit액션 실행 로그");
		BoardVO data = boardDAO.selectOne(boardVO);
		System.out.println(data); //로깅
		request.setAttribute("data", data);
		// 수정하기 위해서 클릭한 글 데이터 받아서 보여줘야함으로
		pageContext.forward("edit.jsp");

	
	
	
	}else if(action.equals("update")){
		System.out.println("update액션 실행 로그");
		System.out.println(boardVO); //로깅
		if(boardDAO.update(boardVO)){
			response.sendRedirect("control.jsp?action=my");
		}else{
			throw new Exception("control-update 오류 로깅");
		}
	
	
	
	}else if(action.equals("delete")){
		System.out.println("delete액션 실행 로그");
		if(boardDAO.delete(boardVO)){
			response.sendRedirect("control.jsp?action=my");
		}else{
			throw new Exception("control-delete 오류 로깅");
		}
		
		
	}else if(action.equals("insert")){
		if(boardDAO.insert(boardVO)){
			response.sendRedirect("control.jsp?action=my");
		}else{
			throw new Exception("control-insert 오류 로깅");
		}
	}





%>