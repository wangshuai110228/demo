<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
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
    <!-- 引文tree的工具js -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/util-js.js"></script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',height:150,title:'上',split:true">
        <div id="chartmain" style="width:600px; height: 400px;"></div>
        <div id="chartmain2" style="width:600px; height: 400px;"></div>
    </div>
    <div data-options="region:'west',width:200,title:'左',split:true">
        <ul id="digui"></ul>
    </div>
    <div data-options="region:'center',width:400,title:'右',split:true">
        <div class="easyui-tabs" data-options="fit:true" id="myTabs">
            <div title="首页">
                <h1>首页</h1>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    $("#digui").tree({
        url:"<%=request.getContextPath() %>/tree/queryTree?pid=0",
        onBeforeExpand:function(node){
            $("#digui").tree("options").url="<%=request.getContextPath() %>/treequeryTree?pid="+node.id;
        },
        onClick:function(node){
            if(node.url!=null){
                if($("#myTabs").tabs("exists",node.text)){
                    $("#myTabs").tabs("select",node.text)
                }else{
                    $("#myTabs").tabs("add",{
                        title:node.text,
                        closable:true,
                        content:creatJsp(node.url),
                        tools:[{
                            iconCls:'icon-reload',
                            handler:function(){
                                $("#myTabs").tabs("update",{
                                    tab:$("#myTabs").tabs("getSelected"),//获取选中的面板
                                    options:{
                                        content:creatJsp(node.url)
                                    }
                                })
                            }
                        }]
                    })
                }
            }
        }
    });

    function creatJsp(url){
        return "<iframe frameborder='0' scrolling='auto' src="+url+" style='width:100%;height:100%'></iframe>";
    }
</script>
</html>
