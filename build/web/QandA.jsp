<%-- 
    Document   : QandA
    Created on : 2012-4-16, 21:50:43
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.gtx.Quesdisplay" %>
<jsp:useBean id="theques" class="com.gtx.Quesdisplay" scope="request"/>
<%
    if(theques.getContent() == null)
    {
        theques = new Quesdisplay();
        theques.setContent("抱歉，没有内容，你也许跳转到了错误的页面。");
        request.setAttribute("theques", theques);
    }
%>

<link rel="stylesheet" href="qandstyle.css" type="text/css">
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script charset="utf-8" src="kindeditor-min.js"></script>  
<script charset="utf-8" src="lang/zh_CN.js"></script>  
<script type="text/javascript">
    $(document).ready(function()
    {
        $("#button_ok").click(function()
        {           
            //if($("#editor_id").text() == "")
            //    {
            //        alert("内容不能为空！");
            //        return false;
            //    }
        })
        var editor = KindEditor.create('textarea[name="content"]', 
         {
                                                width: '770px',
                                                fontSizeTable : '18x',
              					resizeType : 0,
                                                items : [
						'forecolor', 'hilitecolor', 'bold', 'underline',
						'removeformat', '|', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
                });
    })
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=utf-8">
        <title>Q & A</title>
    </head>
    <body>

        <div class="level">
            <jsp:getProperty name="theques" property="level"/>
            <hr class="hr0">
        </div>
        <div class="questionblock">
            <p>题目正文：</p>
            <jsp:getProperty name="theques" property="content"/>
            <br/>
            <div class="sign">
                <p>提问人：<jsp:getProperty name="theques" property="asker"/></p>
                <p>在<jsp:getProperty name="theques" property="date"/></p>
            </div>
            <hr class="hr1">
            <div class="socrecontrol">
                <button id="addscore">加1分</button>
                <button id="descroe">减1分</button>
            </div>
        </div>
        <div class="anwserblock">
            <p>我要回答</p>
            <div id="editorcontainer" style="display: block">
                <form action="AnswerHandle?queID=${theques.getQuesID()}" method="post">
                    <textarea id="editor_id" name="content" style="width:800px;height:200px;"></textarea>
                    <div id="canvascontainer" style="display: none; width: 800px; height: 200px"
                        <canvas id="thecanvas"></canvas>        
                    </div>
                    <div style="text-align: center">  
                        <button id="button_ok">OK</button>
                    </div>
                </form>
            </div>
        </div>
        
    </body>
</html>
