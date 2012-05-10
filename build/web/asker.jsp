<%-- 
    Document   : index
    Created on : 2012-4-9, 22:05:43
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<link rel="stylesheet" href="asker.css" type="text/css">


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
        $("#button_ok").click(function(check)
        {           
            var text = EditorObject.html();
            if(text == "")
            {
                alert("你没输入任何内容！");
                check.preventDefault();
            }
        })
         window.EditorObject = KindEditor.create('textarea[name="content"]', 
         {
                                                fontSizeTable : '18x',
              					resizeType : 0,
                                                items : [
						'forecolor', 'hilitecolor', 'bold', 'underline',
						'removeformat', '|', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
         });
    })
    function ajaxAddtag()
    {
        var newtag = document.getElementById("newtag").value;
        if(newtag != "")
        {
            $.get("Dealtag", {newtag: newtag}, function(data)
            {
                data = decodeURI(data);
                
                var stall = [];
                stall = data.split("|");
                alert(stall[0]);
                document.getElementById("tagselect").innerHTML += ("<option value=" + stall[1] + ">" + stall[0] + "</option>");
            });
            
            return false;
        }
        else
        {
            alert("没有内容！");
            
            return false;
        }
    }
</script>


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
                    
                    <select name="tag" id="tagselect">
                        <c:forEach var="onetag" items="${taglist}">
                            <option value="${onetag.getTagid()}">${onetag.getTag()}</option>
                        </c:forEach>
                    </select>
                    <input id="newtag" type="text">
                    <button id="addtag" onclick="return ajaxAddtag();">新增标签</button>
                </div>
                <div>  
                    <button id="button_ok">OK</button>
                </div>
            </form>
        </div>
