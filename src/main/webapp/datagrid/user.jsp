<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    $(function () {

        $("#btn").linkbutton({
            onClick: function () {
                var titles = $("#user_cc").combotree("getText")
                var fileds = $("#user_cc").combotree("getValues")
                console.log(titles);
                var a="";
                $.each(fileds, function (index, filed) {
                   if (index==fileds.length-1){
                       a+=filed;
                   }else {
                       a+=filed+",";
                   }
                })
              $("#user_ff").form('submit',{
                  url:"${pageContext.request.contextPath}/user/customerExport",
                  queryParams:{
                      titles:titles,
                      fileds:a
                  }
              })



            }
        })
        $('#user_dg').datagrid({
            url: '${pageContext.request.contextPath}/user/getAllUser',
            pagination:true,
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'name', title: '姓名', width: 100},
                {field: 'dharmaName', title: '法名', width: 100},
                {field: 'regDate', title: '注册日期', width: 100, align: 'right'}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: [{
                text: "全部导出",
                iconCls: 'icon-edit',
                handler: function () {
                    //alert('编辑按钮')
                    var opts = $("#user_dg").datagrid("getColumnFields");
                    console.log(opts);
                    window.location.href="${pageContext.request.contextPath}/user/export?opts="+opts;
                }
            }, '-', {
                text: "全部导入",
                iconCls: 'icon-help',
                handler: function () {
                }
            }, '-', {
                text: "自定义导出",
                iconCls: 'icon-help',
                handler: function () {
                    $("#user_dd").dialog("open")
                }
            }]

        });
    })
</script>


<table id="user_dg"></table>

<div id="user_dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <div style="text-align: center">
        <select id="user_cc" class="easyui-combotree" style="width:200px;" data-options="required:true,checkbox:true,multiple:true,onlyLeafCheck:true,
data:[{
		text: '请选择',
		state: 'closed',
		children: [{
		    id:'id',
			text: '编号'
		},{
		    id:'name',
			text: '姓名'
		},{
		    id:'dharmaName',
			text: '法名'
		},{
		    id:'regDate',
			text: '生日'
		}]
	}]"></select>
        <form id="user_ff" method="post">

            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定</a>

        </form>
    </div>

</div>
