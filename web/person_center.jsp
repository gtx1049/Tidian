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
		<link rel="stylesheet" type="text/css"  href="person_center.css" />
		<script type="text/javascript" src="person_center.js"></script>
	</head>
	<body>
		<div id="header">
		
		</div>
		
		<div id="middle">
			<div class="logo">                          
				<a href=""><jsp:getProperty name="user" property="usrName"/>的空间</a>
			</div>
			<div class="select">
				<ul>
                                    <li><a href="#" id="person_index"  onclick="_Onclick();return false;">个人主页</a></li>
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
					<li><a href="#" id="2" onclick="Onclick(this); return false;">我的题库</a></li>
					<li><a href="#" id="3" onclick="Onclick(this); return false;">喜爱文章</a></li>
					<li><a href="#" id="4" onclick="Onclick(this); return false;">收藏资料</a></li>
					<li><a href="#" id="5" onclick="Onclick(this); return false;">为我推荐</a></li>
				</ul>
			</div>
		</div>

		
		<div id="content">
			<div id="welcome" class="dis">
                            <h1>${user.getNickname()}</h1>
                            <p>
                                ${user.getNickname()}, 欢迎回到您在题典网的家<br/><br/>
                                今日名言：长风破浪会有时，直挂云帆寄沧海
                            </p>
			</div>
			<div id="questions" class="undis">
                            <div class="qdescription">
                                <p>题库名称:</p>
                                <c:out value="${personQuestions.getPqName()}">
                                </c:out>
                                <p>创建日期:</p>
                                <c:out value="${personQuestions.getSetTime().toString().substring(3, 10)}">
                                </c:out>
                            </div>
       
                            <div  class="question">
                                <ul>
                                <c:forEach var="question" items="${questions}">
              
                                    <li><a href="QuesFromDB?quesID=${question.getQueId()}">${question.getSubject()}</a></li>
                                </c:forEach>                               
                                </ul>
                                 <%                            
                                    Integer question_number = (Integer)session.getAttribute("question_number");                                                                        
                                    int _current = 1;     
                                    out.println("<div class='selectPage'>");                                                                                                     
                                    while(question_number>0){                                        
                                        out.println("<a href='person_center?qpage=");
                                        out.println(_current);
                                        out.println("'>");
                                        out.println(_current++);
                                        out.println("</a>");
                                        question_number = question_number - 1;
                                        
                                    }                                    
                                    out.println("</div>");
                                %>
                            </div>


			</div>

			<div id="articles" class="undis">
                            <span id="d">articles</span>
                                <ul>
                                <c:forEach var="article" items="${articles}">
                                    <li><a href="">${article.getTopic()}</a></li>
   
                                </c:forEach>                               
                                </ul>
                                <%
                                    Integer art_number = (Integer)session.getAttribute("art_number");                                                                        
                                    int current = 1;     
                                    out.println("<div class='selectPage'>");                                                                                                     
                                    while(art_number>0){                                        
                                        out.println("<a href='person_center?page=");
                                        out.println(current-1);
                                        out.println("'>");
                                        out.println(current++);
                                        out.println("</a>");
                                        art_number = art_number - 10;
                                        
                                    }                                    
                                    out.println("</div>");
                                %>
			</div>
			
			<div id="materials" class="undis">
				materials
                                <ul>
                                <c:forEach var="material" items="${materials}">
                                    <li><a href="">${material.getMatId()}</a></li>
                                </c:forEach>
                                </ul>
			</div>
			
			<div id="recommendations" class="undis">
				recommendations
			</div>
		</div>
		<hr/>
	</body>
</html>
