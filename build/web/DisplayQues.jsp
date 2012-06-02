<%-- 
    Document   : DisplayQues
    Created on : 2012-5-5, 20:16:14
    Author     : Administrator
--%>
<link rel="stylesheet" type="text/css"  href="css/DisplayQues.css" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.gtx.Quesdisplay" %>


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

        <h4>最新问题展板</h4>
        <div class="news-container" style="width: 750px; margin: auto;">
        <ul>
            <c:forEach var="oneques" items="${quesli}">
                <li style="height: 170px">
                    <div class="questionblock" style="width: 720px; height: 150px">
                        <p><a href="QuesFromDB?quesID=${oneques.getQuesID()}">${oneques.getContent()}</a></p>
                    </div>
                </li>
            </c:forEach>
        </ul>
        </div>
