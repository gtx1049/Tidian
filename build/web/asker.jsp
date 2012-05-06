<%-- 
    Document   : index
    Created on : 2012-4-9, 22:05:43
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="qandstyle.css" type="text/css">

<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script charset="utf-8" src="kindeditor-min.js"></script>  
<script charset="utf-8" src="lang/zh_CN.js"></script>  
<script type="text/javascript">
    $(document).ready(function()
    {
        $("#defaultchoose").attr("checked","checked");
        $(".btn-slide").click(function()
        {
            $("#editorcontainer").slideToggle("slow");
            $(this).toggleClass("active");
            return false;
        })
        $("#button_ok").click(function()
        {           
            //if($("#editor_id").val() == "")
            //    {
            //        alert("内容不能为空！");
            //        return false;
            //    }
        })
        var editor = KindEditor.create('textarea[name="content"]', 
         {
                                                fontSizeTable : '18x',
              					resizeType : 0,
                                                items : [
						'forecolor', 'hilitecolor', 'bold', 'underline',
						'removeformat', '|', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
         });
    })
</script>

<html>
    <head>
        <meta charset="utf-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>The Editor</h1>
        <hr class="hr0"/>
        <p class="slide"><a href="#" class="btn-slide active">我要出题</a></p>
        <div id="editorcontainer" style="display: none">  
            <form action="EditHandle" method="post">
                <textarea id="editor_id" name="content" style="width:778px;height:200px;"></textarea>
                <div id="canvascontainer" style="display: none; width: 778px; height: 200px"
                    <canvas id="thecanvas"></canvas>        
                </div>
                <div>
                    <select name="grade">
                        <option value="mid1">初一</option>
                        <option value="mid2">初二</option>
                        <option value="mid3">初三</option>
                        <option value="hig1">高一</option>
                        <option value="hig2">高二</option>
                        <option value="hig3">高三</option>
                    </select>
                    <select name="subject">
                        <option value="math">数学</option>
                        <option value="chin">语文</option>
                        <option value="engl">英语</option>
                        <option value="phys">物理</option>
                        <option value="chem">化学</option>
                        <option value="biol">生物</option>
                    </select>
                    <input type="radio" name="qtype" value="select" id="defaultchoose"/>选择
                    <input type="radio" name="qtype" value="blank"/>填空
                    <input type="radio" name="qtype" value="anwser"/>解答
                </div>
                <div>  
                    <button id="button_ok">OK</button>
                </div>
            </form>
        </div>
    </body>
</html>
