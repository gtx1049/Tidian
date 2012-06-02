<%-- 
    Document   : findplatform
    Created on : 2012-5-24, 16:00:56
    Author     : Administrator
--%>
<%@page import="java.util.Date"%>
<%@page import="com.entity.Platforms"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.entity.Users"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="css/findplatform.css" />
        <script type="text/javascript" src="jquery-1.7.2.min.js"></script>
        <script charset="utf-8" src="kindeditor-min.js"></script>  
        <script charset="utf-8" src="lang/zh_CN.js"></script>  
        <script type="text/javascript">
    $(document).ready(function()
    {
        var editor = KindEditor.create('textarea[name="content"]', 
         {
                                                
              					resizeType : 0,
                                                items : [
						'forecolor', 'hilitecolor', 'bold', 'underline',
						'removeformat', '|', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
                });
    })
</script>
    </head>
    <body>
        <div class="middle">
			<ul>				
                            	<li class="index"><a href="Platform">论坛首页</a></li>
                                <li class="new"><a href="#deliever">回复</a></li>
			</ul>
                </div>
        <div class="bottom">
            <div>
                <p class="topic">主题：${platform.getTopic()}</p>
                    <%
                              Platforms platform = (Platforms)request.getAttribute("platform");
                              String content =new String(platform.getContent());
                              request.setAttribute("content", content);
                    %>
                <p>${content}</p>
            </div>
            <div>
                <ul class="pla">
                    <li class="pla_information">作者：${platform.getUsrId().getUsrName()}</li>

                    <li class="pla_information">${platform.getSetDate()}</li>
                    <li class="favorite"><a href="PlatFav?pla_id=${platform.getPlaId()}">顶</a></li>
                </ul>
                <hr/>
            </div>
        </div>
        <ul>
            <c:forEach var="pla_reply" items="${pla_replies}" varStatus="status">
                                <li class="floor">${status.count}楼</li>
                <li class="reply">${pla_reply.getContent()}</li>
                <ul class="pla">
                    <li class="pla_information">作者：${pla_reply.getUsrId().getUsrName()}</li>
                    <li class="pla_information">${pla_reply.getDate()}</li> 
                </ul>
                <hr/>
            </c:forEach>
        </ul>
        
         <a name="deliever"/>
		<div class="deliever">
			<h4>回复</h4>
                        <form action="pla_replyadd?pla_id=${platform.getPlaId()}&usr_id=${user.getUsrId()+0}" method="post">                          
                            <textarea id="editor_id" name="content" style="width:800px;height:200px;"></textarea>                                
                            <input class="submit" value=" " type="submit"/>
                        </form>
		</div>
    </body>
</html>
