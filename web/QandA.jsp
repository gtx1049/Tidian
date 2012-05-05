<%-- 
    Document   : QandA
    Created on : 2012-4-16, 21:50:43
    Author     : Administrator
--%>
<style>
.anwserblockdis
{
    padding:5px 10px; 
    border-radius:10px;
    -moz-border-radius:25px; 
    background-color: #E9ECA2;
    border:2px solid #a1a1a1;
    font: 100% Arial, Helvetica, sans-serif;
}
</style>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        $("#queaddscore").click(function()
        {
            var queID = document.getElementById("queaddscore").value;
            $.get("Dealscore", {action:"add", classify: "ques", ID:queID}, function(data)
            {
                if(data == "true")
                {
                    alert("成功加分！");
                }
                else if(data == "false")
                {
                    alert("你已经不能为此题投票了。");
                }
            });
        }
        )
        $("#quedescore").click(function()
        {
            var queID = document.getElementById("quedescore").value;
            $.get("Dealscore", {action:"decrease", classify: "ques", ID:queID}, function(data)
            {
                if(data == "true")
                {
                    alert("减分成功！");
                }
                else if(data == "false")
                {
                    alert("你已经不能为此题投票了。");
                }
            });
        }
        )
                
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
    function ajaxAnsaddscore(thebutton)
    {
        var ansID = document.getElementById(thebutton.id).value;
        $.get("Dealscore", {action:"add", classify: "ans", ID:ansID}, function(data)
        {
            if(data == "true")
            {
                  ansID = ansID.substring(ansID.indexOf('+'));
                  var scoreID = "ansscore" + ansID;
                  var score = parseInt(document.getElementById(scoreID).innerHTML);
                  score += 1;
                  document.getElementById(scoreID).innerHTML = score;
                  alert("成功加分！");
            }
            else if(data == "false")
            {
                alert("您已经不能在评分了！");
            }
        });
        
    }
    function ajaxAnsdescore(thebutton)
    {
        var ansID = document.getElementById(thebutton.id).value;
        $.get("Dealscore", {action:"decrease", classify: "ans", ID:ansID}, function(data)
        {
            if(data == "true")
            {
                  ansID = ansID.substring(ansID.indexOf('+'));
                  var scoreID = "ansscore" + ansID;
                  var score = parseInt(document.getElementById(scoreID).innerHTML);
                  score -= 1;
                  document.getElementById(scoreID).innerHTML = score;
                  alert("减分成功！");
            }
            else if(data == "false")
            {
                alert("您已经不能在评分了！");
            }        
        });
    }
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
                <button id="queaddscore" value="${theques.getQuesID()}">加1分</button>
                <button id="quedescore" value="${theques.getQuesID()}">减1分</button>
            </div>
        </div>
        <c:forEach var="oneans" items="${answers}">
            <div class="anwserblockdis">
                <p>${oneans.getContent()}</p>
                <hr class="hr1">
                <div class="sign">
                    <p>回答者：<c:out value="${oneans.getRespondent()}"></c:out></p>
                    <p>在<c:out value="${oneans.getDate()}"></c:out></p>
                </div>
                <div class="socrecontrol">
                    score:<span id="ansscore${oneans.getAnsID()}"><c:out value="${oneans.getScore()}"></c:out></span>
                    <button id="ansaddscore+${oneans.getAnsID()}" value="${oneans.getAnsID()}" onclick="ajaxAnsaddscore(this);">加1分</button>
                    <button id="ansdescore+${oneans.getAnsID()}" value="${oneans.getAnsID()}" onclick="ajaxAnsdescore(this);">减1分</button>
                </div>
            </div>
        </c:forEach>
        <div class="anwserblock">
            <p>我要回答</p>
            <div id="editorcontainer" style="display: block">
                <form action="AnswerHandle?queID=<%=theques.getQuesID()%>" method="post">
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
