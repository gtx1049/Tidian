<%@page import="com.entity.Articles"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="blog.css" />
        <title>BLOG.TIDIAN.COM</title>
    </head>
    <body>
        <div id="nav">
            <div id="nav_list">
                <a href="index.jsp" title="题典网首页">首页</a>
                <a href=""><span>博客专栏</span></a>
                <a href=""><span>热门文章</span></a>
                <a href=""><span>排行榜</span></a>
            </div>
        </div>
        <div id="main_content">
            <div id="main_left">
                <div id="side_nav">
                    <ul>
                        <li><a href="">语文</a></li>
                        <li><a href="">数学</a></li>
                        <li><a href="">英语</a></li>
                        <li><a href="">物理</a></li>
                        <li><a href="">化学</a></li>
                        <li><a href="">生物</a></li>
                    </ul>
                </div>
            </div>
            <div id="main_center">
                <div id="blog_command">
                    <h3><b class="tit">最新精华博文推荐</b></h3>
                    <ul>
                        <li><a href="">This is the first blog!</a></li>
                        <li><a href="">This is the second blog!</a></li>
                        <li><a href="">This is the third blog!</a></li>
                        <li><a href="">This is the fourth blog!</a></li>
                        <li><a href="">This is the fifth blog!</a></li>
                        <li><a href="">This is the sixth blog!</a></li>
                    </ul>
                </div>
                <div id="sub_nav">
                </div>
                <%
                    List<Articles> pageArticles = (List<Articles>)request.getAttribute("pageArticles");
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
                                <img src="" alt="A Image" />
                            </a>
                            <dt>
                            <dd>
                                <%=new String(pageArticles.get(i).getContent()) %>
                            </dd>
                        </dl>
                        <div id="about_info">
                            <span>
                                
                                <span class="time"><%=new java.util.Date(pageArticles.get(i).getWriteTime().getTime())%> </span>
                                <a href="" class="monthy_scan">月点击量:<%=pageArticles.get(i).getMonthlyScan() %> </a>
                                <a href="" class="total_scan">总点击量:<%=pageArticles.get(i).getTotalScan() %></a>
                                <a href="" class="collect_number">收藏量:<%=pageArticles.get(i).getCollectNumber() %> </a>
                            </span>
                        </div>
                    </div>
                    <%}
                %>
                <div id="blog_list">
                    <h1>
                        <a href="" class="category">[编程语言]</a>
                        <a href="">程序员必须知道的那些事儿</a>
                    </h1>
                    <dl>
                        <dt>
                        <a href="">
                            <img src="" alt="A Image"/>
                        </a>
                        </dt>
                        <dd>本示例说明:
1.自定义listview条目样式,自定义listview显示列数的多少,灵活与数据库中字段绑定.
2.实现对DB的增删改查,并且操作后listview自动刷新.
3.响应用户操作点击事件,示例中展示单击时取出主键Id和其他内容.
4.响应用户操作长按事件,示例中展示长按时根据主键Id来编辑和删除数据.
5.表现层与数据处理层分开,不依赖于cursor(使用cursor不易...
                        </dd>
                    </dl>
                    <div id="about_info">
                        <span>
                            <a href="" class="user_name">TonyHe</a>
                            <span class="time">昨天00：00</span>
                            <a href="" class="monthy_scan">月点击量(1000)</a>
                            <a href="" class="total_scan">总点击量(5000)</a>
                            <a href="" class="collect_number">收藏量(100)</a>
                        </span>
                    </div>
                </div>
                <div id="blog_list">
                    <h1>
                        <a href="" class="category">[编程语言]</a>
                        <a href="">extjs JsonStore加载数据</a>
                    </h1>
                    <dl>
                        <dt>
                        <a href="">
                            <img src="" alt="A Image"/>
                        </a>
                        </dt>
                        <dd>xml文件存储了用户的信息，可以当数据库来使用，查询时使用xpath方式，方便。
                            package com.java.study;

                            import org.dom4j.Document;
                            import org.dom4j.DocumentException;
                            import org...
                        </dd>
                    </dl>
                    <div id="about_info">
                        <span>
                            <a href="" class="user_name">EnthPan</a>
                            <span class="time">昨天12：00</span>
                            <a href="" class="monthy_scan">月点击量(1000)</a>
                            <a href="" class="total_scan">总点击量(5000)</a>
                            <a href="" class="collect_number">收藏量(100)</a>
                        </span>
                    </div>
                </div>
                <div id="blog_list">
                    <h1>
                        <a href="" class="category">[编程语言]</a>
                        <a href="">extjs JsonStore加载数据</a>
                    </h1>
                    <dl>
                        <dt>
                        <a href="">
                            <img src="" alt="A Image"/>
                        </a>
                        </dt>
                        <dd>xml文件存储了用户的信息，可以当数据库来使用，查询时使用xpath方式，方便。
                            package com.java.study;

                            import org.dom4j.Document;
                            import org.dom4j.DocumentException;
                            import org...
                        </dd>
                    </dl>
                    <div id="about_info">
                        <span>
                            <a href="" class="user_name">EnthPan</a>
                            <span class="time">昨天12：00</span>
                            <a href="" class="monthy_scan">月点击量(1000)</a>
                            <a href="" class="total_scan">总点击量(5000)</a>
                            <a href="" class="collect_number">收藏量(100)</a>
                        </span>
                    </div>
                </div>
                <div id="page_nav">
                    <span>总共10页</span><strong><a href="blogServlet?page=1">1</a></strong><a href="blogServlet?page=2">2</a><a href="blogServlet?page=3">3</a><a href="blogServlet?page=4">4</a>
                    <a href="blogServlet?page=5">5</a><a href="blogServlet?page=6">...</a><a href="blogServlet?page=2">下一页</a>
                </div>
            </div>
            <div id="main_right">
                <div id="hot_blog">
                    <h2>两天热门文章</h2>
                    <ul class="list_2">
                        <li><a href="">程序员必知8大排序3大查找</a></li>
                        <li><a href="">如何有效地帮助新人融入项目中</a></li>
                        <li><a href="">程序员的半衰期只有15年？</a></li>
                        <li><a href="">如何摆脱菜鸟界面</a></li>
                        <li><a href="">你的代码（软件）安全吗？</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
