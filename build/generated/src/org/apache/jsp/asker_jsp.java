package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class asker_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"qandstyle.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-1.7.2.min.js\"></script>\n");
      out.write("<script charset=\"utf-8\" src=\"kindeditor-min.js\"></script>  \n");
      out.write("<script charset=\"utf-8\" src=\"lang/zh_CN.js\"></script>  \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function()\n");
      out.write("    {\n");
      out.write("        $(\"#defaultchoose\").attr(\"checked\",\"checked\");\n");
      out.write("        $(\".btn-slide\").click(function()\n");
      out.write("        {\n");
      out.write("            $(\"#editorcontainer\").slideToggle(\"slow\");\n");
      out.write("            $(this).toggleClass(\"active\");\n");
      out.write("            return false;\n");
      out.write("        })\n");
      out.write("        $(\"#button_ok\").click(function()\n");
      out.write("        {           \n");
      out.write("            //if($(\"#editor_id\").val() == \"\")\n");
      out.write("            //    {\n");
      out.write("            //        alert(\"内容不能为空！\");\n");
      out.write("            //        return false;\n");
      out.write("            //    }\n");
      out.write("        })\n");
      out.write("        var editor = KindEditor.create('textarea[name=\"content\"]', \n");
      out.write("         {\n");
      out.write("                                                fontSizeTable : '18x',\n");
      out.write("              \t\t\t\t\tresizeType : 0,\n");
      out.write("                                                items : [\n");
      out.write("\t\t\t\t\t\t'forecolor', 'hilitecolor', 'bold', 'underline',\n");
      out.write("\t\t\t\t\t\t'removeformat', '|', 'insertorderedlist',\n");
      out.write("\t\t\t\t\t\t'insertunorderedlist', '|', 'emoticons', 'image', 'link']\n");
      out.write("         });\n");
      out.write("    })\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>The Editor</h1>\n");
      out.write("        <hr class=\"hr0\"/>\n");
      out.write("        <p class=\"slide\"><a href=\"#\" class=\"btn-slide active\">我要出题</a></p>\n");
      out.write("        <div id=\"editorcontainer\" style=\"display: none\">  \n");
      out.write("            <form action=\"EditHandle\" method=\"post\">\n");
      out.write("                <textarea id=\"editor_id\" name=\"content\" style=\"width:778px;height:200px;\"></textarea>\n");
      out.write("                <div id=\"canvascontainer\" style=\"display: none; width: 778px; height: 200px\"\n");
      out.write("                    <canvas id=\"thecanvas\"></canvas>        \n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <select name=\"grade\">\n");
      out.write("                        <option value=\"mid1\">初一</option>\n");
      out.write("                        <option value=\"mid2\">初二</option>\n");
      out.write("                        <option value=\"mid3\">初三</option>\n");
      out.write("                        <option value=\"hig1\">高一</option>\n");
      out.write("                        <option value=\"hig2\">高二</option>\n");
      out.write("                        <option value=\"hig3\">高三</option>\n");
      out.write("                    </select>\n");
      out.write("                    <select name=\"subject\">\n");
      out.write("                        <option value=\"math\">数学</option>\n");
      out.write("                        <option value=\"chin\">语文</option>\n");
      out.write("                        <option value=\"engl\">英语</option>\n");
      out.write("                        <option value=\"phys\">物理</option>\n");
      out.write("                        <option value=\"chem\">化学</option>\n");
      out.write("                        <option value=\"biol\">生物</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"radio\" name=\"qtype\" value=\"select\" id=\"defaultchoose\"/>选择\n");
      out.write("                    <input type=\"radio\" name=\"qtype\" value=\"blank\"/>填空\n");
      out.write("                    <input type=\"radio\" name=\"qtype\" value=\"anwser\"/>解答\n");
      out.write("                </div>\n");
      out.write("                <div>  \n");
      out.write("                    <button id=\"button_ok\">OK</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
