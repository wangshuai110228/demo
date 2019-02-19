<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/2/1
  Time: 16:39
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
<!-- //条查 -->
<div id="searchDiv">
    <a href="javascript:openDig()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
</div>

<table id="calalog"></table>


<div id="myCalalog" class="easyui-dialog" style="width:800px;height:400px" data-options="modal:true,collapsible:true,minimizable:true,maximizable:true,resizable:true,buttons:'#myButt',closed:true,iconCls:'icon-save'">
    <form id="CalalogForm" method="post">
        <table>
            <tr>
                <td>名称</td>
                <td>
                    <input class="easyui-textbox" name="caname">
                </td>
            </tr>
            <tr>
                <td>路径</td>
                <td>
                    <input class="easyui-textbox" name="calink">
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="myButt">
    <a href="javascript:addCatalog()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
    <a href="javascript:closeDig()" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'">关闭</a>
</div>

</body>
<script>

    //条件查询
    function searchUSer(){
        $("#calalog").datagrid("load",{

        })
    }

    $(function () {
        initCalalogTable();
    })
    //查询
    function initCalalogTable() {
        $("#calalog").datagrid({
            url: "<%=request.getContextPath() %>/catalog/queryCatalog",
            columns: [[
                {field: 'caid', title: 'id'},
                {field: 'caname', title: '名称'},
                {field: 'calink', title: '路径'},
                {field: 'catime', title: '时间'},
            ]],
            fit: true,
            loadMsg: "正在努力加载中。。。", //请求后台的提示信息
            //singleSelect:true,      //只能单选
            toolbar: "#searchDiv"     //添加工具栏 ： div的id
        })
    }

    //关闭按钮
    function closeDig(){
        $("#myCalalog").dialog('close');
    }
    //新增、修改用户
    function addCatalog(){
        $("#CalalogForm").form("submit",{
            url:"<%=request.getContextPath() %>/catalog/addCalalog",
            success:function(){
                $.messager.alert("提示","保存成功！","info");
                //关闭弹框
                $("#myCalalog").dialog('close');
                //刷新页面
                searchUSer();
            }
        })
    }
    //打开新增对话框
    function openDig(){
        //重置表单
        $("#CalalogForm").form("reset");
        $("#myCalalog").dialog({
            title:'新增用户',
            closed:false   //true 关闭 false 打开
        })
    }

</script>
</html>
