package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class StudyTagHandler extends SimpleTagSupport {
	private String color;
	private String size ;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public void doTag() throws IOException, JspException {
		JspWriter out= getJspContext().getOut();
		
		JspFragment body = getJspBody();
		
		if(body != null) {
			System.out.println("body null°ª ·Î±ë");
			
			out.println("<h1");
			out.println("<p style='font-size:");
			out.println(size);
			out.println("; color:");
			out.println(color);
			out.println("'>");
			body.invoke(null);;
			out.println("</p>");
			out.println("</h1>");
		}
		
		//<p style="font-size:${size}; color:${color};"><jsp:doBody /></p>
		//out.println("<p style="+"'font-size:" + size + "; color:"+color+";'><jsp:doBody /></p>");
		
		/*out.println("<p style='font-size:");
		out.println(size);
		out.println("; color:");
		out.println(color);
		out.println("'>");
		out.println("</p>");*/
		
		/*StringBuffer sb = new StringBuffer();
		sb.append("<p style='font-size:").append(size).append("; color:").append(color).append("'> ").append("</p>");

		out.println(sb.toString());*/
		
		
	}
	
	
	
}
