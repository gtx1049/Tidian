package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DisplayQues_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"qandstyle.css\" type=\"text/css\">\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-1.7.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"jquery.vticker-min.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $('.news-container').vTicker({\n");
      out.write("                speed: 500,\n");
      out.write("                pause: 3000,\n");
      out.write("                showItems: 1,\n");
      out.write("                animation: 'fade',\n");
      out.write("                mousePause: true,\n");
      out.write("                height: 0,\n");
      out.write("                direction: 'up'\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <div class=\"news-container\" style=\"width: 260px; margin: auto;\">\n");
      out.write("<ul>\n");
      out.write("\t<li style=\"height:40px\"><a href=\"#\">这是新闻标题1</a><br /></li>\n");
      out.write("\t<li style=\"height:40px\"><a href=\"#\">新闻2</a><br /></li>\n");
      out.write("\t<li style=\"height:40px\"><a href=\"#\">新闻3</a><br /></li>\n");
      out.write("\t<li style=\"height:40px\"><a href=\"#\">新闻4</a><br /></li>\n");
      out.write("\t<li style=\"height:40px\"><a href=\"#\">新闻5</a><br /></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
