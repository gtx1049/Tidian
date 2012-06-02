<%-- 
    Document   : materialshort
    Created on : 2012-5-15, 20:51:40
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>题典网资料分类</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="资料分类">
		<link rel="stylesheet" type="text/css"  href="css/materialsort.css" />
		<script type="text/javascript" src="materialsort.js"></script>
	</head>

	<body>
		<div class="main">
		<div class="right">
			<div class="rank_board">
				<div><img id="deliver" src="images/deliver.jpg" onmouseover="over(1)" onmouseout="over(2)"/></div>
				<div class="theme"><span>周下载量排行</span></div>
				<div class="download">

				</div>
				<div class="theme"><span>总收藏排行</span></div>
				<div class="collect">

				</div>
			</div>
		</div>
		<div class="left">
			<div class="grade">
				<ul>
					<li><a href="material?subject= &grade=1" class="theme">初一</a></li>
					<li><a href="material?subject= &grade=2" class="theme">初二</a></li>
					<li><a href="material?subject= &grade=3" class="theme">初三</a></li>
					<li><a href="material?subject= &grade=4" class="theme">高一</a></li>
					<li><a href="material?subject= &grade=5" class="theme">高二</a></li>
					<li><a href="material?subject= &grade=6" class="theme">高三</a></li>
				</ul>
			</div>
			<div class="material">
				<ul>
                                    <c:forEach var="con" items="${content}">
                                        <li>${con.getMname()}</li>
                                    </c:forEach>
				</ul>
			</div>
		</div>
		</div>
	</body>
</html>