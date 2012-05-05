package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gtx.Quesdisplay;

public final class QandA_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("<style>\n");
      out.write(".anwserblockdis\n");
      out.write("{\n");
      out.write("    padding:5px 10px; \n");
      out.write("    border-radius:10px;\n");
      out.write("    -moz-border-radius:25px; \n");
      out.write("    background-color: #E9ECA2;\n");
      out.write("    border:2px solid #a1a1a1;\n");
      out.write("    font: 100% Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("</style>\n");
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
      out.write("        $(\"#button_ok\").click(function()\n");
      out.write("        {           \n");
      out.write("            //if($(\"#editor_id\").text() == \"\")\n");
      out.write("            //    {\n");
      out.write("            //        alert(\"内容不能为空！\");\n");
      out.write("            //        return false;\n");
      out.write("            //    }\n");
      out.write("        })\n");
      out.write("        var editor = KindEditor.create('textarea[name=\"content\"]', \n");
      out.write("         {\n");
      out.write("                                                width: '770px',\n");
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
      out.write("                <button id=\"queaddscore\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${theques.getQuesID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">加1分</button>\n");
      out.write("                <button id=\"quedescroe\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${theques.getQuesID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">减1分</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <div class=\"anwserblock\">\n");
      out.write("            <p>我要回答</p>\n");
      out.write("            <div id=\"editorcontainer\" style=\"display: block\">\n");
      out.write("                <form action=\"AnswerHandle?queID=");
      out.print(theques.getQuesID());
      out.write("\" method=\"post\">\n");
      out.write("                    <textarea id=\"editor_id\" name=\"content\" style=\"width:800px;height:200px;\"></textarea>\n");
      out.write("                    <div id=\"canvascontainer\" style=\"display: none; width: 800px; height: 200px\"\n");
      out.write("                        <canvas id=\"thecanvas\"></canvas>        \n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"text-align: center\">  \n");
      out.write("                        <button id=\"button_ok\">OK</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("oneans");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${answers}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <div class=\"anwserblockdis\">\n");
          out.write("                <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getContent()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                <hr class=\"hr1\">\n");
          out.write("                <div class=\"sign\">\n");
          out.write("                    <p>回答者：");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</p>\n");
          out.write("                    <p>在");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</p>\n");
          out.write("                </div>\n");
          out.write("                <div class=\"socrecontrol\">\n");
          out.write("                    score:");
          if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                    <button id=\"ansaddscore\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getAnsID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">加1分</button>\n");
          out.write("                    <button id=\"ansdescroe\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getAnsID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">减1分</button>\n");
          out.write("                </div>\n");
          out.write("            </div>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getRespondent()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getDate()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oneans.getScore()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }
}
