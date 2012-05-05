<%-- 
    Document   : DisplayQues
    Created on : 2012-5-5, 20:16:14
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="qandstyle.css" type="text/css">
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery.vticker-min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
        $(document).ready(function () {
            $('.news-container').vTicker({
                speed: 500,
                pause: 3000,
                showItems: 1,
                animation: 'fade',
                mousePause: true,
                height: 0,
                direction: 'up'
            });
        });
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="news-container" style="width: 260px; margin: auto;">
<ul>
	<li style="height:40px"><a href="#">这是新闻标题1</a><br /></li>
	<li style="height:40px"><a href="#">新闻2</a><br /></li>
	<li style="height:40px"><a href="#">新闻3</a><br /></li>
	<li style="height:40px"><a href="#">新闻4</a><br /></li>
	<li style="height:40px"><a href="#">新闻5</a><br /></li>
</ul>
</div>
    </body>
</html>
