<%--
  Created by IntelliJ IDEA.
  User: Machenike
  Date: 2019/1/23
  Time: 11:20
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
<body id="body">
<div class="easyui-dialog" data-options="closable:false,title:'系统登录',buttons:'#mybutton'" style="width:400px;height:200px">
    <form method="post" id="loginForm">
        <table>
            <tr>
                <td>登录账号</td>
                <td><input class="easyui-textbox" name="username"  data-options="iconCls:'icon-man',required:true"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input class="easyui-passwordbox" name="userpwd" data-options="iconCls:'icon-lock',required:true"></td>
            </tr>
        </table>
    </form>
</div>
<div id="mybutton">
    <a href="javaScript:loginUser()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a>
    <a href="javaScript:addloginUser()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">注册</a>
</div>
</body>
<script type="text/javascript">
    //登录
    function loginUser(){
        $("#loginForm").form("submit",{
            url:"<%=request.getContextPath() %>/login/queryUserByLogin",
            success:function(data){
                if(data=="登录成功"){
                    $.messager.alert("提示",data,"info")
                    location.href="<%=request.getContextPath() %>/page/tree"
                }else{
                    $.messager.alert("提示",data,"error")
                }

            }
})
}
</script>
</body>
</html>
