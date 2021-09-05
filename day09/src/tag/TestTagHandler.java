package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport{ //SimpleTagSupport 상속
	// 해당 태그가 호출되면(NewFile1.jsp) 미리 만들어둔 doTag메서드가 사용됨! 
	
	public void doTag() throws IOException { // 시작태그를 만나면 호출됨 
		// jsp로부터 정보를 받아올 수 있게하는 메서드 
		// getOut() : out객체를 참조할때 사용
		JspWriter out = getJspContext().getOut();
		out.println("태그핸들러 클래스 기반 실습중!");
	
	}
	
	
	
	
}
