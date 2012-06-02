<%-- 
    Document   : Ranking
    Created on : 2012-5-26, 9:25:44
    Author     : nankonami
--%>

<%@page import="com.tidian.model.Articles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/blog.css" type="text/css" />
        <link rel="stylesheet" href="css/Rank.css" type="text/css" />
        <title>JSP Page</title>
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
        <div id="main_con">
            <div class="ranking">
                <h1>博文月排行</h1>
                <dl>
                    <dt><span class="top">排名</span><span class="title">标题</span><span class="num">阅读量</span></dt>
                    <div class="inner">
                        <ul class="rank_list">
                            <%
                                List<Articles> monthyArticles = (List<Articles>)request.getAttribute("monthyBlog");
                                for(int i = 0; i < monthyArticles.size(); i++)
                                {
                                    if( i <= 2)
                                    {%>
                                    <li class="top3"><em><%=i+1 %></em><a href="" target="_blank" title="<%=monthyArticles.get(i).getTopic() %>">
                                            <%=monthyArticles.get(i).getTopic() %></a><span><%=monthyArticles.get(i).getMonthlyScan() %></span>
                                    </li>
                                    <%}else
                                      {
                            %>
                            <li><em><%=i+1 %></em><a href="" target="_blank" title="<%=monthyArticles.get(i).getTopic() %>">
                                        <%=monthyArticles.get(i).getTopic() %></a><span><%=monthyArticles.get(i).getMonthlyScan() %></span>
                                    
                                </li> 
                                    <%}
                                }
                            %>
                        </ul>
                    </div>
                </dl>
            </div>
            <div class="ranking">
                <h1>博文总排行</h1>
                <dl>
                    <dt><span class="top">排名</span><span class="title">标题</span><span class="num">阅读量</span></dt>
                    <div class="inner">
                        <ul class="rank_list">
                            <%
                                List<Articles> totalArticles = (List<Articles>)request.getAttribute("totalBlog");
                                for(int i = 0; i < totalArticles.size(); i++)
                                {
                                    if( i <= 2)
                                    {%>
                                    <li class="top3"><em><%=i+1 %></em><a href="" target="_blank" title="<%=totalArticles.get(i).getTopic() %>">
                                            <%=totalArticles.get(i).getTopic() %></a><span><%=totalArticles.get(i).getTotalScan() %></span>
                                    </li>
                                    <%}else
                                      {
                            %>
                            <li><em><%=i+1 %></em><a href="" target="_blank" title="<%=totalArticles.get(i).getTopic() %>">
                                        <%=totalArticles.get(i).getTopic() %></a><span><%=totalArticles.get(i).getTotalScan() %></span>
                                    
                                </li> 
                                    <%}
                                }
                            %>
                        </ul>
                    </div>
                </dl>
            </div>
            <div class="ranking">
                <h1>博文收藏量排行</h1>
                <dl>
                    <dt><span class="top">排名</span><span class="title">标题</span><span class="num">收藏量</span></dt>
                    <div class="inner">
                        <ul class="rank_list">
                            <%
                                List<Articles> collectArticles = (List<Articles>)request.getAttribute("collectBlog");
                                for(int i = 0; i < collectArticles.size(); i++)
                                {
                                    if( i <= 2)
                                    {%>
                                    <li class="top3"><em><%=i+1 %></em><a href="" target="_blank" title="<%=collectArticles.get(i).getTopic() %>">
                                            <%=collectArticles.get(i).getTopic() %></a><span><%=collectArticles.get(i).getCollectNumber() %></span>
                                    </li>
                                    <%}else
                                      {
                            %>
                            <li><em><%=i+1 %></em><a href="" target="_blank" title="<%=collectArticles.get(i).getTopic() %>">
                                        <%=collectArticles.get(i).getTopic() %></a><span><%=collectArticles.get(i).getCollectNumber() %></span>
                                    
                                </li> 
                                    <%}
                                }
                            %>
                        </ul>
                    </div>
                </dl>
            </div>
        </div>
    </body>
</html>
