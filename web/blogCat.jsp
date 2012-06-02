<%-- 
    Document   : blogCat
    Created on : 2012-5-26, 16:15:48
    Author     : nankonami
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tidian.model.Articles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/blog.css" />
        <title>BLOG.TIDIAN.COM</title>
    </head>
    <body>
        <div id="nav">
            <div id="nav_list">
                <a href="index.jsp" title="题典网首页">首页</a>
                <a href="HotBlog?page=1"><span>热门文章</span></a>
                <a href="RankBlog"><span>排行榜</span></a>
                <a href="newArticle.jsp"><span>发表博文</span></a>
            </div>
        </div>
        <div id="main_content">
            <div id="main_left">
                <div id="side_nav">
                    <ul>
                        <li><a href="CatBlog?category=Chinese&page=1">语文</a></li>
                        <li><a href="CatBlog?category=Math&page=1">数学</a></li>
                        <li><a href="CatBlog?category=English&page=1">英语</a></li>
                        <li><a href="CatBlog?category=Physic&page=1">物理</a></li>
                        <li><a href="CatBlog?category=Chemistry&page=1">化学</a></li>
                        <li><a href="CatBlog?category=Biology&page=1">生物</a></li>
                    </ul>
                </div>
            </div>
            <div id="main_center">
                <div id="sub_nav">
                </div>
                <%
                    List<Articles> pageArticles = (List<Articles>)request.getAttribute("pageArticlesForCat");
                    for(int i = 0; i < pageArticles.size(); i++)
                    {%>
                    <div id="blog_list">
                        <h1>
                            <a href="" class="category">[<%=pageArticles.get(i).getCategory() %>]</a>
                            <a href=""><%=pageArticles.get(i).getTopic() %></a>
                        </h1>
                        <dl>
                            <dt>
                            <a href="">
                                <img src="./pic/test.jpg" alt="A Image" />
                            </a>
                            <dt>
                            <dd>
                                <%=new String(pageArticles.get(i).getContent()) %>
                            </dd>
                        </dl>
                        <div id="about_info">
                            <span>
                                <a href="" class="user_name"><%=pageArticles.get(i).getUsrId().getUsrName() %> </a>
                                <%
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    String time = format.format(pageArticles.get(i).getWriteTime());
                                %>
                                <span class="time"><%=time %> </span>
                                <a href="" class="monthy_scan">月点击量:<%=pageArticles.get(i).getMonthlyScan() %> </a>
                                <a href="" class="total_scan">总点击量:<%=pageArticles.get(i).getTotalScan() %></a>
                                <a href="" class="collect_number">收藏量:<%=pageArticles.get(i).getCollectNumber() %> </a>
                            </span>
                        </div>
                    </div>
                    <%}
                %>
                <div id="page_nav">
                    <%
            Object total = request.getAttribute("totalPageForCat");
            int totalPage = Integer.valueOf(String.valueOf(total));
            Object left = request.getAttribute("partLeftForCat");
            int partLeft = Integer.valueOf(String.valueOf(left));
            Object part = request.getAttribute("totalPartForCat");
            int totalPart = Integer.valueOf(String.valueOf(part)).intValue();
            int pageMent = Integer.valueOf(request.getParameter("pageMent"));
            
            
            if(totalPart == 1)
            {
                for(int i = 1; i <= totalPage; i++)
                {%>
                <a href="CatBlog?page=<%=i %>"><%=i %></a>
                <%}
            }else if(totalPart != 1 && pageMent == 0)
            {%>
            <span>总共<%=totalPage %></span>
            <%
                for(int k = 1; k <= 5; k++)
                {%>
                <a href="CatBlog?page=<%=pageMent*5+k %>"><%=pageMent*5+k %></a>
                <%}
                %>
                <a href="CatBlog?page=<%=Integer.valueOf(request.getParameter("page"))+1 %>">next</a>
            <%
            }else if(totalPart != 1 && pageMent == totalPart - 1)
            {%>
            <a href="CatBlog?page=<%=Integer.valueOf(request.getParameter("page")) - 1 %>">上一页</a>
            <%
                for(int j = 1; j <= partLeft; j++)
                {%>
                <a href="CatBlog?page=<%=pageMent*5 + partLeft %>"><%=pageMent*5 + partLeft %></a>
                <%}
            %>
            <%}else
            {%>
        <a href="CatBlog?page=<%=Integer.valueOf(request.getParameter("page")) - 1 %>">上一页</a>
        <a href="CatBlog?page=<%=pageMent*5+1 %>"><%=pageMent*5+1 %></a>
        <a href="CatBlog?page=<%=pageMent*5+2 %>"><%=pageMent*5+2 %></a>
        <a href="CatBlog?page=<%=pageMent*5+3 %>"><%=pageMent*5+3 %></a>
        <a href="CatBlog?page=<%=pageMent*5+4 %>"><%=pageMent*5+4 %></a>
        <a href="CatBlog?page=<%=pageMent*5+5 %>"><%=pageMent*5+5 %></a>
        <a href="CatBlog?page=<%=pageMent*5+6 %>">...</a>
        <a href="CatBlog?page=<%=Integer.valueOf(request.getParameter("page")) +1 %>">下一页</a>
            <%}
            %>
                </div>
            </div>
            <div id="main_right">
                <div id="hot_blog">
                    <h2>两天热门文章</h2>
                    <ul class="list_2">
                        <%
                            List<Articles> hotArticles = (List<Articles>)request.getAttribute("hotArticlesForCat");
                            for(int k = 0; k < hotArticles.size(); k++)
                            {%>
                            <li><a href=""><%=hotArticles.get(k).getTopic() %></a></li> 
                            <%}
                        %>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
