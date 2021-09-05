<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>

<%@ attribute name="color" %>
<%@ attribute name="size" %>


<%-- <h2 style= "color: ${color}; fontSize: ${fontSize}" ><jsp:doBody/></h2> --%>

<%-- <font color= "${color}" size="${size}" ><jsp:doBody/></font> --%>

<p style="font-size:${size}; color:${color};"><jsp:doBody /></p>