<%-- 
    Document   : index
    Created on : 2012-5-8, 15:36:01
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>题典网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="中学生学生交流平台，使你的学习变得更加愉快高效">
		<link rel="stylesheet" type="text/css"  href="css/index.css" />
		<script type="text/javascript" src="index.js"></script>
                <script type="text/javascript" src="jquery-1.7.2.min.js"></script>
                <script charset="utf-8" src="kindeditor-min.js"></script>  
                <script charset="utf-8" src="lang/zh_CN.js"></script>  
                <script type="text/javascript" src="jquery.vticker-min.js"></script>
	</head>
	<body >
		<div id="header_top">		
			<span class="header_welcome">${user.getNickname()} 欢迎来到题典网</span>
                        <c:choose>
                        <c:when test="${user == null}">	
				<form class="form" method="post" action="Log">				
                                    <select name="login" id="login">
                                        <option value="username">用户名</option>
                                        <option value="uid">Email</option>
                                    </select>
                                    <input type="text" name="username" id="username" autocomplete="off"/>
								
                                    <span>密码</span>&nbsp<input type="password" name="password" id="password"/>
                                    <input name="submit" type="submit" value="确定"/>
                                </form>
                        </c:when>
                            <c:when test="${user != null}">
                                <form class="_form" method="post" action="Log">                            
                                    <input name="submit" type="submit" value="安全退出"/>
                                </form>
                            </c:when>
                        </c:choose>
				<a href="Register.html" id="top1">注册</a>
				<a href="" id="top2">忘记密码</a>
		</div>
		<div id="header_middle" >
				<img  src="images/head_picture.jpg" class="header_picture"/>
				
		</div>
		<div id="header_bottom">
			<ul >
				<li id="picture7"><a onmouseover="over(this);" onmouseout="out(this);" id="p7" href="">神级功能</a></li>
				<li id="picture6"><a onmouseover="over(this);" onmouseout="out(this);" id="p6" href="person_center">个人中心</a></li>
				<li id="picture5"><a onmouseover="over(this);" onmouseout="out(this);" id="p5" href="Platform">灌水论坛</a></li>
				<li id="picture4"><a onmouseover="over(this);" onmouseout="out(this);" id="p4" href="">答疑解惑</a></li>
				<li id="picture3"><a onmouseover="over(this);" onmouseout="out(this);" id="p3" href="blogServlet?page=1">经验分享</a></li>
				<li id="picture2"><a onmouseover="over(this);" onmouseout="out(this);" id="p2" href="material">资料下载</a></li>
				<li id="picture1"><a onmouseover="over(this);" onmouseout="out(this);" id="p1" href="IndexControl">首页</a></li>			
			</ul>
		</div>

		<div id="question_wall">
                    <c:import url="DisplayQues.jsp"/>
		</div>
		<div id="question_search">
                    <h4>问题搜索区</h4>
                    <div class="search">
                        <form action="search" method="get">
                            <input type="text" name="search"/><br><br>
                            <input type="submit" value="进入题典"/>
                        </form>
                    </div>
		</div>
		<div id="platform">
			<h4>灌水论坛专区</h4>
                        <ul class="list">
                            <c:forEach var="platform" items="${index_platforms}">
                                <li class="platfor"><a href="FindPlatform?pla_id=${platform.getPlaId()}">${platform.getTopic()}</a></li>
                            </c:forEach>
                        </ul>
		</div>
		<div id="experience">
			<h4>经验分享专区</h4>
                        <ul class="list">
                            <c:forEach var="article" items="${index_articles}">
                                <li class="platfor"><a href="FindPlatform?pla_id=${platform.getPlaId()}">${article.getTopic()}</a></li>
                            </c:forEach>
                        </ul>
		</div>
		<div id="material">
			<ul>
				<li  id="mat_chinese"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="1" href="#">语文</a></li>
				<li id="mat_math"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="2" href="#">数学</a></li>
				<li id="mat_english"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="3" href="#">英语</a></li>
				<li id="mat_physics"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="4" href="#">物理</a></li>
				<li id="mat_chemistry"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="5" href="#">化学</a></li>
				<li id="mat_biology"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="6" href="#">生物</a></li>
				<li id="mat_politics"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="7" href="#">政治</a></li>
				<li id="mat_history"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="8" href="#">历史</a></li>
				<li id="mat_geography"><a onclick="Onclick(this);return false;" onmouseover="_over(this);" onmouseout="_out(this);" id="9" href="#">地理</a></li>
			</ul>
		<div class="dis">
		语文
		</div>
		<div class="undis">
		数学
		</div>
		<div class="undis">
		英语
		</div>
		<div class="undis">
		物理
		</div>
		<div class="undis">
		化学
		</div>
		<div class="undis">
		生物
		</div>
		<div class="undis">
		政治		
		</div>
		<div class="undis">
		历史
		</div>
		<div class="undis">
		地理
		</div>
		</div>
		<div id="recommand">
                    <h4>为您推荐</h4>
                        <div class="list">
                            <ul>
                                <c:forEach var="recArticle" items="${recArticles}">
                                    <li><a href="ShowBlog?">${recArticle.getTopic()}</a></li>
                                </c:forEach>
                            </ul>
			</div>
			
		</div>

		<div id="question">
                    <c:import url="asker.jsp"/>
		</div>
                    <c:import url="bottom.jsp"/>
	</body>
</html>
