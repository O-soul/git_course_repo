package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\t<h1>Edit account</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"/account\" method=\"post\">\r\n");
      out.write("\t<table>\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><label for=\"fname\">First Name</label></td>\t\t\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"fname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.getFname()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\t\t\r\n");
      out.write("\t\t\t<td><label for=\"lname\">Last Name</label></td>\t\t\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"lname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.getLname()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><label for=\"lname\">Current password</label></td>\t\t\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"currentPassword\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><label for=\"lname\">New Password</label></td>\t\t\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"password\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\t\t\r\n");
      out.write("\t\t<td><label for=\"lname\">Confirm Password</label></td>\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"passwordConfirm\" /></td>\r\n");
      out.write("\t</tr>\t\r\n");
      out.write("\t</table>\t\t\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Update\" />\r\n");
      out.write("\t</form>\r\n");
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
