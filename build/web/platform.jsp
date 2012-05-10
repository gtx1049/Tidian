<%-- 
    Document   : platform
    Created on : 2012-5-4, 18:18:44
    Author     : Administrator
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<!DOCTYPE html>
<html>
	<head>
		<title>题典网论坛</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="论坛，你在题典网放松的乐园">
		<link rel="stylesheet" type="text/css"  href="platform.css" />
		<script type="text/javascript" src="platform.js"></script>
		<script type="text/javascript" src="index.js"></script>
	</head>
	<body>
		<div class="header">
			Welcome to our platform
		</div>
		<div class="middle">
			<ul class="right">
				<li class="new"><a href="#deliever">发表新贴</a></li>
			</ul>
			<ul class="left">
				<li class="main"><a href="">精品</a></li>
				<li class="index"><a href="">首页</a></li>
			</ul>
                </div>
		<div class="content">

		<div class="rightside">
			<div class="information">
				<p>个人信息</p>
                                <p>${user.getNickname()}</p>
			</div>
			<span>评论数排行</span>
			<div class="com_rank">
                            <c:forEach var="com_platform" items="${com_platforms}">
                                <li class="_platform"><a href="FindPlatform?pla_id=${com_platform.getPlaId()}">${com_platform.getTopic()}</a></li>
                        </c:forEach>
			</div>
			<span>喜欢数排行</span>
			<div class="fav_rank">
                            
                            <c:forEach var="fav_platform" items="${fav_platforms}">
                                <li class="_platform"><a href="FindPlatform?pla_id=${fav_platform.getPlaId()}">${fav_platform.getTopic()}</a></li>
                            </c:forEach>
			</div>
		</div>
		<div class="leftside">
                    <ul class="pla_inf_right">
                        <li>作者</li>
                        <li>最后回复</li>
                    </ul>
                    <ul class="pla_inf_left">
                        <li>点击</li>
                        <li>回复</li>
                        <li>标题</li>
                    </ul>
                        <ul>
                        <c:forEach var="platform" items="${platforms}" varStatus="status">                        
                        <ul class="pla_inf_right">
                            <li class="author">${platform.getUsrId().getUsrName()}</li>
                            <li class="reply_time">${platform.getLastDate().toString().substring(3, 10)}</li>                          
                        </ul>
                        <ul class="pla_inf_left">
                            <li class="click_number">${platform.getClickNumber()}</li>
                            <li class="reply_number">${platform.getCommentNumber()}</li>
                            <c:choose>
                                <c:when test="${status.count%2==0}">
                                    <li class="platform" class="platform1"><a href="FindPlatform?pla_id=${platform.getPlaId()}"  class="topic">${platform.getTopic()}</a></li>
                                </c:when>                                    
                                <c:when test="${status.count%2!=0}">
                                    <li class="platform" class="platform2"><a href="FindPlatform?pla_id=${platform.getPlaId()}"  class="topic">${platform.getTopic()}</a></li>
                                </c:when>
                            </c:choose>
                        </ul>
                            <hr/>
                    </c:forEach>
                    </ul>
                    <%
                                    Integer pla_size = (Integer)request.getAttribute("pla_size");
                                    int _pla_size = pla_size;
                                    int total_page = 0;
                                    Integer cpage = (Integer)request.getAttribute("cpage");
                                    int _current = cpage - cpage%10 +1;
                                    pla_size = pla_size - (_current-1) * 40; 
                                    out.println("<div class='selectPage'>");                                                                                                     
                                        out.println("<a href='Platform?page=");
                                        out.println(0);
                                        out.println("'>");
                                        out.println("首页");
                                        out.println("</a>");
                                        
                                        out.println("<a href='Platform?page=");
                                        if(cpage-1>=0)
                                            out.println(cpage-1);
                                        else
                                            out.println(0);
                                        out.println("'>");
                                        out.println("上一页");
                                        out.println("</a>");
                                        
                                    while(pla_size>0 && ++total_page <= 10){
                                        out.println("<a href='Platform?page=");
                                        out.println(_current-1);
                                        out.println("'>");
                                        out.println(_current++);
                                        out.println("</a>");
                                        pla_size -= 40;                    
                                    }
                                        out.println("<a href='Platform?page=");
                                        if(cpage+1<=_pla_size/40)
                                            out.println(cpage+1);
                                        else
                                            out.println(cpage);
                                        out.println("'>");
                                        out.println("下一页");
                                        out.println("</a>");                                                                                
                                        out.println("<a href='Platform?page=");
                                        if(_pla_size%40==0)
                                            out.println(_pla_size/40-1);
                                        else
                                            out.println(_pla_size/40);
                                        out.println("'>");
                                        out.println("尾页");
                                        out.println("</a>");
                                    out.println("</div>");
                                %>
                </div>
		</div>
                <a name="deliever"/>
		<div class="deliever">
			<h4>发表新贴</h4>
                        <form action="Platform_add" method="post">
                            <span>标题</span><br/>
                            <input type="text" name="topic" style="width: 800px;"/><br/>                            
                            <span>内容</span>
                            <textarea id="editor_id" name="content" style="width:800px;height:200px;"></textarea>                                
                            <input class="submit" value=" " type="submit"/>
                        </form>
		</div>
                <c:import url="bottom.jsp"/>
	</body>
</html>
