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

		JspFragment body = getJspBody(); // �ܺ�(jsp)�������� ����� �±׹ٵ� ������ �޾ƿ�

		if (body != null) { // ���� �±׹ٵ� �ִٸ�,
			out.println("<h1>");
			body.invoke(null);
			// �ٵ� �ִ� ���� ��� --> body�� �����ϴ� ��ü���� nullpointexception�Ͼ ���� �ֱ� ������ if�� ó�� �ʿ��ϴ�!!!!��
			out.println("</h1>");
		}

		DataBean db = new DataBean();

		// ��Ʈ�����۸� �̿��غ��� -> ���� ȿ���� ���� (�޼ҵ� ���� ȣ���ϱ� ���� )
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">");

		/* ���� �ڵ�
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
