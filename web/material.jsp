<%-- 
    Document   : material
    Created on : 2012-5-15, 20:51:26
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>题典网资料中心</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="description" content="资料首页">
		<link rel="stylesheet" type="text/css"  href="css/material.css" />
		<script type="text/javascript" src="material.js"></script>
	</head>

	<body>
		<div class="middle">
			<p>
				<img src="images/material.jpg"/>
			</p>
		</div>

		<div class="main">
			<div class="rank">
				<div class="rank_board"><span>浏览量排行榜</span></div>
				<ul class="navigation">
					<li class="tab1" onmouseover="over(1);">本周</li>
					<li class="tab2" onmouseover="over(2);">本月</li>
					<li class="tab3" onmouseover="over(3);">总计</li>
				</ul>
				<br/>
				<br/>
					<div class="scan">
						<div id="s_week" style="display:block;">
						1ddd
						</div>
						<div id="s_month" style="display:none;">
						2
						</div>
						<div id="s_total" style="display:none;">
						3
						</div>
					</div>
				<div class="rank_board"><span>下载量排行榜</span></div>
                                <ul class="navigation">
					<li class="tab1" onmouseover="over(4);">本周</li>
					<li class="tab2" onmouseover="over(5);">本月</li>
					<li class="tab3" onmouseover="over(6);">总计</li>
				</ul>
				<br/>
				<br/>
					<div class="download">
						<div id="d_week" style="display:block;">
                                                    <ul>
                                                        <c:forEach var="weekDownloadSorted" items="${weekDownloadSorted}">
                                                            <li>${weekDownloadSorted.getMname()}</li>
                                                        </c:forEach>
                                                    </ul>
						</div>
						<div id="d_month" style="display:none;">
                                                    <ul>
                                                        <c:forEach var="weekDownloadSorted" items="${weekDownloadSorted}">
                                                            <li>${weekDownloadSorted.getMname()}</li>
                                                        </c:forEach>
                                                    </ul>
						</div>
						<div id="d_total" style="display:none;">

                                                    <ul>
                                                        <c:forEach var="totalDownloadSorted" items="${totalDownloadSorted}">
                                                            <li>${totalDownloadSorted.getMname()}</li>
                                                        </c:forEach>
                                                    </ul>
						</div>
					</div>
			</div>
			<div class="content">

				<div class="math right">
                                    <a href="material?subject=math" class="theme">数学</a><br/>
                                    <ul>
                                        <c:forEach var="mat" items="${math}">
                                            <li>${mat.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>

				<div class="chinese left">
                                    <a href="materialsort?subject=chinese" class="theme">语文</a><br/>
                                    <ul>
                                        <c:forEach var="chin" items="${chinese}">
                                            <li>${chin.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>
				
				<div class="physics right">
				    <a href="material?subject=physics" class="theme">物理</a><br/>
                                                                        <ul>
                                        <c:forEach var="phy" items="${physics}">
                                            <li>${phy.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>
			
				<div class="english left">
				    <a href="material?subject=english" class="theme">英语</a><br/>
                                                            <ul>
                                        <c:forEach var="eng" items="${english}">
                                            <li>${eng.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>
							
				<div class="biology right">
                                <a href="material?subject=biology" class="theme">生物</a><br/>
                                                        <ul>
                                        <c:forEach var="bio" items="${biology}">
                                            <li>${bio.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>
			
				<div class="chemistry left">
				<a href="material?subject=chemistry" class="theme">化学</a><br/>
                                                        <ul>
                                        <c:forEach var="che" items="${chemistry}">
                                            <li>${che.getMname()}</li>
                                        </c:forEach>
                                    </ul>
				</div>

			

			</div>
		</div>
	</body>
</html>