<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    $(function () {
        $('#chapter').treegrid({
            url:'${pageContext.request.contextPath}/album/getAlbumTree.do',
            fit:true,
            fitColumns:true,
            idField:'id',
            treeField:'name',
            onDblClickRow:function (row) {
                $("#audio").dialog("open");
                $("#src").prop("src","${pageContext.request.contextPath}/"+row.url);

            },
            columns:[[
                {title:'名称',field:'name',width:180},
                {field:'url',title:'下载路径',width:60,align:'right'},
                {field:'size',title:'大小',width:80},
                {field:'duration',title:'时长',width:80}
            ]],
            toolbar: [{
                text:'专辑详情',
                iconCls: 'icon-print',
                handler: function(){
                    var row = $('#chapter').treegrid("getSelected");
                    console.log(row);
                    $("#albumDialog").dialog("open");
                    $("#coverImg").prop("src","${pageContext.request.contextPath}"+row.coverImg);
                    $("#name").val(row.name);
                    $("#aucthor").val(row.aucthor);
                    $("#broadCast").val(row.broadCast);
                    $("#count").val(row.count);
                    $("#score").val(row.score);
                    $("#publishDate").val(row.publishDate);
                    $("#brief").val(row.brief);
                }
            },'-',{
                iconCls: 'icon-add',
                text:'添加专辑',
                handler: function(){
                    $("#albumAddDialog").dialog("open");
                }
            },'-',{
                iconCls: 'icon-add',
                text:'添加章节',
                handler: function(){
                    $("#chapterAddDialog").dialog("open");
                }
            },'-',{
                iconCls: 'icon-cut',
                text:'下载音频',
                handler: function(){
                    var row = $('#chapter').treegrid("getSelected");
                    console.log(row.url);
                    window.location.href="${pageContext.request.contextPath}/chapter/download.do?filename="+row.url;
                    /*$.ajax({

                        type:'post',
                        data:{"filename":row.url}
                    })*/
                }
            }]
        });
        /*专辑详情框*/
        $("#albumDialog").dialog({
            closed:true,
            //buttons:"#addSubmitBtn",
            title:"专辑详情对话框",
            width:500
        })
        //专辑添加框
        $("#albumAddDialog").dialog({
            closed:true,
            //buttons:"#addSubmitBtn",
            title:"专辑添加对话框",
            width:500
        })
        //章节添加框
        $("#chapterAddDialog").dialog({
            closed:true,
            //buttons:"#addSubmitBtn",
            title:"章节添加对话框",
            width:500
        })
        $("#audio").dialog({
            closed:true,
            //buttons:"#addSubmitBtn",
            title:"音频播放框",
            width:500
        })
    })
    function doInsert() {
        $("#insertform").form("submit",{
            url:"${pageContext.request.contextPath}/album/add.do",
            success:function(data){
                if(data == "true"){
                    $.messager.show({
                        title:"添加提示",
                        showType:"slide",
                        msg:"添加成功"
                    });
                }else{
                    $.messager.show({
                        title:"添加提示",
                        showType:"slide",
                        msg:"添加失败"
                    });
                }
                //关闭添加对话框
                $("#albumAddDialog").dialog("close");
                //刷新datagrid
                $("#chapter").treegrid("reload");
            }
        });
    }
    function doInsert2() {
        var row = $('#chapter').treegrid("getSelected");
        console.log(row);
        $("#chapterform").form("submit",{
            url:"${pageContext.request.contextPath}/chapter/add.do",
            queryParams:{"aid":row.id},
            success:function(data){
                if(data == "true"){
                    $.messager.show({
                        title:"添加提示",
                        showType:"slide",
                        msg:"添加成功"
                    });
                }else{
                    $.messager.show({
                        title:"添加提示",
                        showType:"slide",
                        msg:"添加失败"
                    });
                }
                //关闭添加对话框
                $("#chapterAddDialog").dialog("close");
                //刷新datagrid
                $("#chapter").treegrid("reload");
            }
        });
    }
</script>


<table id="chapter"></table>

<!--专辑详情对话框-->
<div id="albumDialog">
    封面:<img id="coverImg" src="" alt="" height="15px" width="15px">标题:<input id="name"/><br/>
    作者:<input id="aucthor"/><br/>
    播音:<input id="broadCast"/><br/>
    集数:<input id="count"/><br/>
    评分:<input id="score"/><br/>
    发布日期:<input id="publishDate"/><br/>
    简介:<input type="textarea" name="" id="brief" cols="30" rows="30"></textarea><br/>
</div>

<%--专辑添加对话框--%>
<div id="albumAddDialog">
    <form id="insertform" method="post" enctype="multipart/form-data">
        标题:<input name="name"/><br/>
        作者:<input name="aucthor"/><br/>
        播音:<input name="broadCast"/><br/>
        封面:<input type="file" name="multipartFile"/><br>
        集数:<input name="count"/><br/>
        评分:<input name="score"/><br/>
        简介:<input type="textarea" name="brief" cols="30" rows="30"></textarea><br/>
        <input type="button" onclick="doInsert()" value="添加">
    </form>
</div>
<%--添加章节对话框--%>
<div id="chapterAddDialog">
    <form id="chapterform" method="post" enctype="multipart/form-data">
        标题:<input name="name"/><br/>
        大小:<input name="size"/><br/>
        时长:<input name="duration"/><br/>
        url:<input type="file" name="multipartFile"/><br>
        <input type="button" onclick="doInsert2()" value="添加">
    </form>
</div>
<div id="audio">
    <audio id="src" src="" controls="controls" autoplay="autoplay"></audio>
</div>
