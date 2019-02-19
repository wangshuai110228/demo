<%--
  Created by IntelliJ IDEA.
  User: Machenike
  Date: 2019/2/10
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入easyui样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/default/easyui.css">
    <!-- 引入easyui图标样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/icon.css">
    <!-- 引入jquery js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.min.js"></script>
    <!-- 引入easyui的js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <!-- 引文easyui支持中文js -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
    <!-- 引入uploadify css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
    <!-- 引入kindeditor css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/kindeditor-4.1.10/themes/default/default.css" />
    <script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
</head>
<body>
<div id="searchDiv2">

    <a href="javascript:deleteBys()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>

</div>


<!-- 定义表格 -->
<table id="myTable2"> </table>
<!-- 定义新增表格 -->
<div id="myDialog" class="easyui-dialog" style="width:400px;height:300px" data-options="modal:true,maximizable:true,resizable:true,buttons:'#myButton',closed:true,iconCls:'icon-save'">
    <form id="myForm" method="post">
        <input style="display: none" name="id">
        <table>
            <tr>
                <td>问题名称</td>
                <td>
                    <input class="easyui-textbox" name="name">
                </td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td>
                    <input class="easyui-datebox" name="createtime">
                </td>
            </tr>
            <tr>
                <td>是否最热</td>
                <td>
                    <input type="radio" name="sfzr"  value="1"/>是
                    <input type="radio" name="sfzr" value="0"/>否
                </td>
            </tr>
        </table>

    </form>

</div>
<!-- 定义按钮 -->
<div id="myButton">
    <a href="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
    <a href="javascript:closeDig()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
</body>
<script>
    //打开对话框
    function openDig() {
        //重置表单
        $("#myForm").form("reset");
        //打开
        $("#myDialog").dialog({
            title:'新增',
            closed:false
        })
    }
    //关闭对话框
    function closeDig(){
        $("#myDialog").dialog("close")
        $("#myForm").form("reset");
    }
    //修改：回显
    function openUpdateBy(id){
        //alert(id)
        $.ajax({
            url:"<%=request.getContextPath() %>/problem/queryProblemById",
            type:"post",
            data:{"id":id},
            success:function(data){
                //数据回显
                $("#myForm").form("load",data);
                //弹框
                $("#myDialog").dialog({
                    title:"修改",
                    closed:false
                })
            }
        })
    }
    //新增//修改
    function add(){
        $("#myForm").form("submit",{
            url:"<%=request.getContextPath() %>/problem/addProblem",
            success:function(){
                $.messager.alert("提示","保存成功","info")
                //关闭弹框
                $("#myDialog").dialog("close")
                //关闭
                closeDig()
                //刷新
                $("#myTable2").datagrid("reload")
            }

        })
    }
    //单个删除
    function deleteByid(id){

        //alert(id)
        $.messager.confirm("提示","是否确定删除!",function(r){
            if(r){
                $.ajax({
                    url:"<%=request.getContextPath() %>/problem/deleteProblemAll",
                    type:"post",
                    data:{"id":id},
                    success:function(){
                        $.messager.alert("提示消息","删除成功","info");
                        $("#myTable2").datagrid("reload")
                    },error:function(){
                        $.messager.alert("提示消息","删除失败","error");


                    }
                })

            }

        })
    }


    //批量删除
    function deleteBys(){

        //获取复选框
        var arr = $("#myTable2").datagrid("getChecked");
        if(arr.length<=0){
            $.messager.alert("提示消息","请至少选择一条数据！","warning");
            return;
        }
        $.messager.confirm("提示","是否确认删除"+arr.length+"条数据？",function(r){
            if(r){
                var ids = "";
                for(var i=0;i<arr.length;i++){
                    //alert(arr[i].id);
                    if(ids==""){
                        ids += arr[i].id;
                    }else{
                        ids += ","+arr[i].id;
                    }
                }

            }

            $.ajax({
                url:"<%=request.getContextPath() %>/problem/deleteProblemAll",
                type:"post",
                data:{"id":ids},
                success:function(){
                    $.messager.alert("提示消息","删除成功","info");
                    $("#myTable2").datagrid("reload")
                },error:function(){
                    $.messager.alert("提示消息","删除失败","error");


                }
            })

        })
    }




    //查询
    $("#myTable2").datagrid({
        url:"<%=request.getContextPath()%>/problem/queryProblem2",
        columns:[[
            {field:'check',checkbox:true},
            {field:'id',title:'编号'},
            {field:'name',title:'问题名称'},
            {field:'createtime',title:'提问时间'},
            {field:'sfzr',title:'是否最热',formatter:function(value,row,index){
                    if(value==1){
                        return "是";
                    }else if(value==0){
                        return "否";
                    }
                }},
            {field:'tools',title:'操作', width:100,align:'center',formatter:function(value,row,index){
                    var str = "<a href='javascript:openUpdateBy("+row.id+")'>修改</a>"
                    str+="| <a href='javascript:deleteByid("+row.id+")'>删除</a>"
                    return str;
                }}

        ]],
        pagination:true,//开启分页
        pageList:[1,2,3,4,5,6], //初始化页面大小选择列表
        pageSize:3 , //初始化每页显示条数，默认是10
        pageNumber:1, //当前页,默认是1
        fit:true,
        toolbar:"#searchDiv2",
        pagePosition:"top"
    })



</script>
</html>

