<%-- 
    Document   : newArticle
    Created on : 2012-5-24, 23:06:44
    Author     : nankonami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newBlog.css" type="text/css" />
        <title>题典--发表博文</title>
    </head>
    <script type="text/javascript" src="jquery-1.7.2.min.js"></script>
    <script charset="utf-8" src="kindeditor-min.js"></script>  
    <script charset="utf-8" src="lang/zh_CN.js"></script>  
    <script type="text/javascript">
    $(document).ready(function()
    {
        var editor = KindEditor.create('textarea[name="content"]', 
         {
                                                
              					resizeType : 0,
                                                items : [
						'forecolor', 'hilitecolor', 'bold', 'underline',
						'removeformat', '|', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
                });
    })
</script>
    <body>
        <div id="newArtilce">
            <form method="POST" action="NewBlog">
                
                            <select class="category" id="category" name="post_cat">
                                <option value="" selected="selected">请选择</option>
                                <option value="语文">语文</option>
                                <option value="英语">英语</option>
                                <option value="数学">数学</option>
                                <option value="物理">物理</option>
                                <option value="化学">化学</option>
                                <option value="生物">生物</option>
                            </select>
                        
                <div class="deliever">
                            <span>标题</span><br/>
                            <input type="text" name="topic" style="width: 1000px;"/><br/>                            
                            <span>内容</span>
                            <textarea id="editor_id" name="content" style="width:1000px;height:400px;"></textarea>                                
                            <input class="submit" value=" " type="submit"/>

		</div>
 
            </form>
        </div>
    </body>
</html>

