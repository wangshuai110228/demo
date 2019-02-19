<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/23
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/ft-carousel.css" />
    <style>
        body{margin: 0;font-family: "微软雅黑";background-color: #1f1f1f;}
        .example {width: 630px;height: 344px;font-size: 40px;text-align: center;margin: 20px auto;background-color: #464576;}
        .carousel-item{line-height: 336px;color: #fff;font-family:  Arial Black}
    </style>
</head>
<body>
<div class="example">
    <div class="ft-carousel" id="carousel_1">
        <ul class="carousel-inner">
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/a.jpg" /></li>
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/b.jpg" /></li>
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/c.jpg" /></li>
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/g.jpg" /></li>
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/q.jpg" /></li>
            <li class="carousel-item"><img src="<%=request.getContextPath() %>/img/v.jpg" /></li>
        </ul>
    </div>
</div>

</body>
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/ft-carousel.min.js"></script>
<script type="text/javascript">
    $("#carousel_1").FtCarousel();

    $("#carousel_2").FtCarousel({
        index: 1,
        auto: false
    });

    $("#carousel_3").FtCarousel({
        index: 0,
        auto: true,
        time: 100,
        indicators: false,
        buttons: true
    });
</script>
</html>
