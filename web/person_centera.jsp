<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Articles"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.entity.Users" scope="session"/>
<!DOCTYPE html>

<html>
    <head>
		<title>题典网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="个人中心，你在题典网的家">
		<link rel="stylesheet" type="text/css"  href="css/person_center.css" />
		<script type="text/javascript" src="person_center.js"></script>
	</head>
	<body>
		<div id="header">
		<a href="IndexControl">首页</a>
		</div>
		
		<div id="middle">
			<div class="logo">                          
				<a href="person_center.jsp"><jsp:getProperty name="user" property="usrName"/>的空间</a>
			</div>
			<div class="select">
				<ul>
                                    <li><a href="person_center.jsp">个人主页</a></li>
					<li><a href="#">个人信息</a></li>
				</ul>
			</div>
		</div>
		<div id="navigation">
			<div class="up">
                            <img id="portrait"　alt="请上传照片" src="<jsp:getProperty name="user" property="portrait" />"></img><br/><br/>
				<form action="FileUploadServlet" enctype="multipart/form-data" method="post">
                                    <input type="file" name="myfile" size="1" maxlength="15"  /><br/>
                                    <input type="submit" value="确认"/>
                                </form>
				<a href="">修改资料</a>
			</div>
			<div>
				<ul>
					<li><a href="person_center?id=1" >我的题库</a></li>
					<li><a href="person_center?id=2" >喜爱文章</a></li>
					<li><a href="person_center?id=3" >收藏资料</a></li>
					<li><a href="person_center?id=4" >为我推荐</a></li>
				</ul>
			</div>
		</div>
		<div id="content">
			<div id="articles">
                                <ul>
                                <c:forEach var="article" items="${articles}">
                                    <li><a href="">${article.getTopic()}</a></li>
   
                                </c:forEach>
                                </ul>
                                          
                                <%
                                    Integer pla_size = (Integer)session.getAttribute("art_number");
                                    int _pla_size = pla_size;
                                    int total_page = 0;
                                    Integer cpage = (Integer)request.getAttribute("apage");
                                    int _current = cpage - cpage%10 +1;
                                    pla_size = pla_size - (_current-1) * 10;
                                    out.println("<div class='selectPage'>");
                                        out.println("<a href='person_center?id=2&apage=");
                                        out.println(0);
                                        out.println("'>");
                                        out.println("首页");
                                        out.println("</a>");
                                        out.println("<a href='person_center?id=2&apage=");
                                        if(cpage-1>=0)
                                            out.println(cpage-1);
                                        else
                                            out.println(0);
                                        out.println("'>");
                                        out.println("上一页");
                                        out.println("</a>");
                                        
                                    while(pla_size>0 && ++total_page <= 10){
                                        out.println("<a href='person_center?id=2&apage=");
                                        out.println(_current-1);
                                        out.println("'>");
                                        out.println(_current++);
                                        out.println("</a>");
                                        pla_size -= 10;                    
                                    }
                                        out.println("<a href='person_center?id=2&apage=");
                                        if(cpage+1<=_pla_size/10)
                                            out.println(cpage+1);
                                        else
                                            out.println(cpage);
                                        out.println("'>");
                                        out.println("下一页");
                                        out.println("</a>");                                                                                
                                        out.println("<a href='person_center?id=2&apage=");
                                        if(_pla_size%40==0)
                                            out.println(_pla_size/10-1);
                                        else
                                            out.println(_pla_size/10);
                                        out.println("'>");
                                        out.println("尾页");
                                        out.println("</a>");
                                    out.println("</div>");
                                %>
			</div>
			
		</div>
		<hr/>
	</body>
</html>
