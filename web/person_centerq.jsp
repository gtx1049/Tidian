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
			<div id="questions">
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
              
                                    <li><a href="QuesFromDB?quesID=${question.getQueId()}">${question.getContent()}</a></li>
                                </c:forEach>                               
                                </ul>
                                 <%                            
                                    Integer question_number = (Integer)session.getAttribute("question_number");                                                                        
                                    int current = (Integer)request.getAttribute("qpage");
                                    int total_number = question_number;
                                    int _current = 1;
                                    if(current % 10!=0){
                                        _current = current - current % 10 +1;
                                    }
                                    else{
                                        _current = current - current % 10 - 10 +1;                               
                                    }
                                    int display_number = 0;
                                    out.println("<div class='selectPage'>");
                                    out.println("<a href='person_center?id=1&qpage=1'>");
                                    out.println("首页</a>");
                                    
                                    out.println("<a href='person_center?id=1&qpage=");
                                    if(current-1>0){
                                        out.println(current-1+"'>");
                                    }
                                    else{
                                        out.println(current+"'>");
                                    }
                                    out.println("上一页</a>");
                                    while(question_number > 0 && display_number++ < 10 && _current <= total_number){
                                        out.println("<a href='person_center?id=1&qpage=");
                                        out.println(_current);
                                        out.println("'onclick=onClick(2)>");
                                        out.println(_current++);
                                        out.println("</a>");
                                        question_number = question_number - 1;
                                    }
                                    out.println("<a href='person_center?id=1&qpage=");
                                    if(current+1 <= total_number){
                                        out.println((current+1)+"'>");
                                    }
                                    else{
                                        out.println(current+"'>");
                                    }
                                    out.println("下一页</a>");
                                    
                                    out.println("<a href='person_center?id=1&qpage=");
                                    out.println(total_number+"'>");
                                    out.println("尾页</a>");
                                    out.println("</div>");
                                %>
                                
                            </div>
			</div>
		</div>
		<hr/>
	</body>
</html>