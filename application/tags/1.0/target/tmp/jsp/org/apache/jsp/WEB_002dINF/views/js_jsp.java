package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class js_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <style type=\"text/css\">\r\n");
      out.write(".flash {\r\n");
      out.write("    border:1px solid red\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    document.onready = function (){\r\n");
      out.write("        regenerate();\r\n");
      out.write("    };\r\n");
      out.write("    function process(){\r\n");
      out.write("        var realleft = Math.round($(\".flash\").css(\"left\").replace(\"px\",\"\"));\r\n");
      out.write("        var realtop = Math.round($(\".flash\").css(\"top\").replace(\"px\", \"\"));\r\n");
      out.write("        if ($(\"#top\").val() == realtop && $(\"#left\").val() == realleft ) {\r\n");
      out.write("            alert(\"Whoo Hoooo! Correct!\");\r\n");
      out.write("        } else {\r\n");
      out.write("            alert(\"Wrong anser. Correct is: left=\" + realleft + \", top=\" + realtop);\r\n");
      out.write("            regenerate();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function regenerate(){\r\n");
      out.write("        $(\".flash\").css({ \"position\": \"absolute\", \"top\": getrand(300) + 200 + \"px\", \"left\": getrand(700) + \"px\" });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function getrand(range){\r\n");
      out.write("        return Math.random() * range;\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<p>Take the coordinates (top and left) of the red div, type them into the input and press verify button. Check the alert message</p>\r\n");
      out.write("Top:<input id=\"top\" type=\"text\" /> <br/>\r\n");
      out.write("Left:<input id=\"left\" type=\"text\" /> <br/>\r\n");
      out.write("<button onclick=\"process()\" id=\"process\">Process</button>\r\n");
      out.write("<hr/>\r\n");
      out.write("<div class=\"flash\"> Find me !</div>\r\n");
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
