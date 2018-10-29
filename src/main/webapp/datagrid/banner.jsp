<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script !src="text/javascript">
    $(function () {
        //添加对话框
        $("#addDiv").dialog({
            closed:true,
            //buttons:"#addSubmitBtn",
            title:"添加对话框",
            width:300
        });
        $("#dg").edatagrid({
            url: "${pageContext.request.contextPath}/banner/getAllBanner.do",
            updateUrl:"${pageContext.request.contextPath}/banner/update.do",
            //destroyUrl:"${pageContext.request.contextPath}/banner/delete.do",
            fit: true,
            fitColumns:true,
            columns: [[
                {field: 'title', title: '标题', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'desc', title: '描述', width: 100, align: 'right'},
                {field: 'createDate', title: '时间', width: 100},
            ]],
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text:"添加",
                handler: function(){
                    alert('添加按钮');
                    $("#addDiv").dialog("open");
                }
            },'-',{
                iconCls: 'icon-edit',
                text:"修改",
                handler: function(){
                    alert('修改按钮');
                    //获取选中的行
                   var row =  $("#dg").edatagrid("getSelected");
                   if(row == null){
                       alert("请先选中一行");
                   }else{
                       var index = $("#dg").edatagrid("getRowIndex",row);
                       $("#dg").edatagrid("editRow",index);
                   }
                }
            },'-',{
                iconCls: 'icon-remove',
                text:"删除",
                handler: function(){
                    //alert('删除按钮');
                    //获取选中的行
                    var row =  $("#dg").edatagrid("getSelected");
                    console.log(row);
                    if(row == null){
                        alert("请选择一行");
                    }else{
                        console.log(row.id);
                        $.messager.confirm('确认对话框', '您确定要删除吗？', function(r){
                            if (r){
                                //删除操作;
                                $.ajax({
                                    url:"${pageContext.request.contextPath}/banner/delete.do",
                                    data:{"id":row.id},
                                    type:"post",
                                    //防止jQuery对json格式的数据做深度序列化==》告诉jQuery别做处理
                                    //traditional:true,
                                    success:function(data){
                                        if(data){
                                            $.messager.show({
                                                title:"删除提示",
                                                showType:"slide",
                                                msg:"删除成功"
                                            });
                                        }else{
                                            $.messager.show({
                                                title:"删除提示",
                                                showType:"slide",
                                                msg:"删除失败"
                                            });
                                        }
                                        //刷新datagrid
                                        $("#dg").edatagrid("reload");
                                    }
                                });
                            }
                        });
                    }
                    //$("#dg").edatagrid("destroyRow");
                }
            },'-',{
                iconCls: 'icon-save',
                text:"保存",
                handler: function(){
                    alert('保存按钮');
                    $("#dg").edatagrid("saveRow");
                }
            }],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.url + '" style="height:80px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.desc + '</p>' +
                    '<p>Date: ' + rowData.createDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
        })
    })
    function doAdd(){
        $("#addForm").form("submit",{
            url:"${pageContext.request.contextPath}/banner/add.do",
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
                $("#addDiv").dialog("close");
                //刷新datagrid
                $("#dg").datagrid("reload");
            }
        });
    }

</script>

<table id="dg"></table>

<!--添加对话框-->
<div id="addDiv">
    <form id="addForm" method="post" enctype="multipart/form-data">
        标题:<input name="title"/><br/>
        密码:<input type="file" name="multipartFile"/><br/>
        描述:<input type="textarea" name="desc" id="" cols="30" rows="10"></textarea><br/>
        状态:<select class="easyui-combobox" name="status" style="width:200px;">
            <option value="Y">展示</option>
            <option value="N">不展示</option>
        </select><br>
        <input type="button" value="添加" onclick="doAdd()">
    </form>
</div>

