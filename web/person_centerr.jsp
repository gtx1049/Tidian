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
                                    <input type="submit" value="确认" />
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
			<div id="recommendations">
				为您推荐的博文
                                <ul>
                                    <c:forEach var="recArticle" items="${recArticles}">
                                        <li><a href="ShowBlog?">${recArticle.getTopic()}</a></li>
                                    </c:forEach>
                                </ul>
			</div>
		</div>
		<hr/>
	</body>
</html>
