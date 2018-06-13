<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <title>学生信息管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/pintuer.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>

    </head>
    <body>
    
        <!--首页面头部开始-->
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <!--首页面头部结束-->
        <!--首页面内容开始-->
        <div class="container padding-big-top padding-big-bottom">
            <div class="line-big">
                <div class="xl12 xs3 xm3 xb3">
                    <div class="panel">
                        <div class="panel-head">友情链接</div>
                        <ul class="list-group">
                            <li>电信学院</li>
                            <li>机械学院</li>
                            <li>经管学院</li>
                            <li>人文社科学院</li>
                            <li>汽车学院</li>
                        </ul>
                    </div>
                </div>
                <div class="xl12 xs9 xm9 xb9">
                    <div class="banner">
                        <div class="carousel">
                            <div class="item">
                                <img src="images/1.jpg" width="100%" alt="1"/>
                            </div>
                            <div class="item">
                                <img src="images/2.jpg" width="100%" alt="2"/>
                            </div>
                            <div class="item">
                                <img src="images/3.jpg" width="100%" alt="3"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--首页面内容结束-->
        <!--首页面尾部开始-->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <!--首页面尾部结束-->
    </body>
</html>
