package tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestTagHandler extends SimpleTagSupport{ //SimpleTagSupport ���
	// �ش� �±װ� ȣ��Ǹ�(NewFile1.jsp) �̸� ������ doTag�޼��尡 ����! 
	
	public void doTag() throws IOException { // �����±׸� ������ ȣ��� 
		// jsp�κ��� ������ �޾ƿ� �� �ְ��ϴ� �޼��� 
		// getOut() : out��ü�� �����Ҷ� ���
		JspWriter out = getJspContext().getOut();
		out.println("�±��ڵ鷯 Ŭ���� ��� �ǽ���!");
	
	}
	
	
	
	
}
