package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.DataBean;

public class MsgTagHandler extends SimpleTagSupport {
	private String bgcolor;
	private String border;

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();

		JspFragment body = getJspBody(); // 외부(jsp)에서부터 날라온 태그바디 내용을 받아옴

		if (body != null) { // 만약 태그바디가 있다면,
			out.println("<h1>");
			body.invoke(null);
			// 바디에 있는 내용 기술 --> body가 수행하는 주체여서 nullpointexception일어날 수도 있기 때문에 if문 처리 필요하다!!!!★
			out.println("</h1>");
		}

		DataBean db = new DataBean();

		// 스트링버퍼를 이용해보자 -> 일의 효율을 위해 (메소드 적게 호출하기 위해 )
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">");

		/* 원래 코드
		 * out.println("<table border="); 
		 * out.println(border); 
		 * out.println(" bgcolor=");
		 * out.println(bgcolor); 
		 * out.println(">");
		 */

		out.println(sb.toString());
		for (String v : db.getDataList()) {
			out.println("<tr><td>" + v + "</tr></td>");
		}
		out.println("</table>");

	}

}
