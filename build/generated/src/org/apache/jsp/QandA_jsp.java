package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gtx.Quesdisplay;

public final class QandA_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
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
      com.gtx.Quesdisplay theques = null;
      synchronized (request) {
        theques = (com.gtx.Quesdisplay) _jspx_page_context.getAttribute("theques", PageContext.REQUEST_SCOPE);
        if (theques == null){
          theques = new com.gtx.Quesdisplay();
          _jspx_page_context.setAttribute("theques", theques, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');

    if(theques.getContent() == null)
    {
        theques = new Quesdisplay();
        theques.setContent("抱歉，没有内容，你也许跳转到了错误的页面。");
        request.setAttribute("theques", theques);
    }

      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"qandstyle.css\" type=\"text/css\">\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-1.7.2.min.js\"></script>\n");
      out.write("<script charset=\"utf-8\" src=\"kindeditor-min.js\"></script>  \n");
      out.write("<script charset=\"utf-8\" src=\"lang/zh_CN.js\"></script>  \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function()\n");
      out.write("    {\n");
      out.write("        var editor = KindEditor.create('textarea[name=\"content\"]', \n");
      out.write("         {\n");
      out.write("                                                fontSizeTable : '18x',\n");
      out.write("              \t\t\t\t\tresizeType : 0,\n");
      out.write("                                                items : [\n");
      out.write("\t\t\t\t\t\t'forecolor', 'hilitecolor', 'bold', 'underline',\n");
      out.write("\t\t\t\t\t\t'removeformat', '|', 'insertorderedlist',\n");
      out.write("\t\t\t\t\t\t'insertunorderedlist', '|', 'emoticons', 'image', 'link']\n");
      out.write("                });\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=utf-8\">\n");
      out.write("        <title>Q & A</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"level\">\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.gtx.Quesdisplay)_jspx_page_context.findAttribute("theques")).getLevel())));
      out.write("\n");
      out.write("            <hr class=\"hr0\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"questionblock\">\n");
      out.write("            <p>题目正文：</p>\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.gtx.Quesdisplay)_jspx_page_context.findAttribute("theques")).getContent())));
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"sign\">\n");
      out.write("                <p>提问人：");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.gtx.Quesdisplay)_jspx_page_context.findAttribute("theques")).getAsker())));
      out.write("</p>\n");
      out.write("                <p>在");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.gtx.Quesdisplay)_jspx_page_context.findAttribute("theques")).getDate())));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <hr class=\"hr1\">\n");
      out.write("            <div class=\"socrecontrol\">\n");
      out.write("                <button id=\"addscore\">加1分</button>\n");
      out.write("                <button id=\"descroe\">减1分</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"anwserblock\">\n");
      out.write("            <p>我要回答</p>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
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
