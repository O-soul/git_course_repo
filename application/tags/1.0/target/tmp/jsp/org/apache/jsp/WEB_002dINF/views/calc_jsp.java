package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Selenium test application</title>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.8.2.min.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    document.onready = function (){\r\n");
      out.write("        $(\"#clear\").hide();\r\n");
      out.write("    };\r\n");
      out.write("    function calc(){\r\n");
      out.write("      $(\"#calc\").hide();\r\n");
      out.write("      $(\"#clear\").show();\r\n");
      out.write("        $.get('/calc/sum?x=' + $(\"#x\").val() + \"&y=\" + $(\"#y\").val(),\r\n");
      out.write("            function (data) {\r\n");
      out.write("                $(\"#r\").append('<div id=\"result\">Result is: ' + data.result + '</div>');\r\n");
      out.write("            }\r\n");
      out.write("        );\r\n");
      out.write("    }\r\n");
      out.write("    function fclear(){\r\n");
      out.write("     $(\"#x\").val(\"\");\r\n");
      out.write("     $(\"#y\").val(\"\");\r\n");
      out.write("     $(\"#result\").remove();\r\n");
      out.write("     $(\"#calc\").show();\r\n");
      out.write("     $(\"#clear\").hide();\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<p>Simple calculator. Enter x and y, press the button, wait for result and verify it</p>\r\n");
      out.write("X:<input id=\"x\" type=\"text\" /> <br/>\r\n");
      out.write("Y:<input id=\"y\" type=\"text\" />\r\n");
      out.write("<hr/>\r\n");
      out.write("<div id=\"r\"> </div>\r\n");
      out.write("<button onclick=\"calc()\"  id=\"calc\">Sum</button>\r\n");
      out.write("<button onclick=\"fclear()\"  value=\"Sum\" id=\"clear\">Clear</button>\r\n");
      out.write("<hr/>\r\n");
      out.write("<a href=\"/\">go back</a>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
