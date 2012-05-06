<%-- 
    Document   : DisplayQues
    Created on : 2012-5-5, 20:16:14
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.gtx.Quesdisplay" %>

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
        <title>Temp display</title>
    </head>
    <body>
        <h1>Questions</h1>
        <div class="news-container" style="width: 320px; margin: auto;">
        <ul>
            <c:forEach var="oneques" items="${quesli}">
                <li style="height: 80px">
                    <div class="questionblock" style="width: 290px; height: 60px">
                    <a href="QuesFromDB?quesID=${oneques.getQuesID()}">${oneques.getContent()}</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
        </div>
    </body>
</html>
