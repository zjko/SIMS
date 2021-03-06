<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div class="panel margin-big-bottom">
                        <div class="panel-head">专业方向</div>
                        <ul class="list-group">
                            <c:forEach var="major" items="${majors}">
                                <li><a href="DisplayStudent?mid=${major.mid}" title="${major.mid}">${major.mname}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <c:if test="${empty grades}"></c:if>
                    <c:if test="${!empty grades}">
                        <div class="panel">
                            <div class="panel-head">班级分类</div>
                            <ul class="list-group">
                                <c:forEach var="grade" items="${grades}">
                                    <li><a href="DisplayStudent?gid=${grade.gid}&mid=${grade.major.mid}" title="${grade.gid}">${grade.gname}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="xl12 xs9 xm9 xb9">
                    <c:if test="${empty students}"><div class="text-large text-center margin-big-bottom">暂无学生信息！</div></c:if>
                    <c:if test="${!empty students}">
                        <div class="text-large text-center margin-big-bottom">学生信息显示</div>
                        <table class="table table-hover table-bordered">
                            <tr>
                                <td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>班级名称</td><td>入学年份</td><td>专业名称</td><td>专业负责人</td>
                            </tr>
                            <c:forEach var="stu" items="${students}">
                                <tr><td>${stu.sno}</td><td>${stu.sname}</td><td>${stu.ssex}</td><td>${stu.sage}</td><td>${stu.grade.gname}</td><td>${stu.grade.year}</td><td>${stu.grade.major.mname}</td><td>${stu.grade.major.director}</td></tr>
                            </c:forEach>
                        </table>
                        <div class="text-center height-big margin-top">
                            ${pagination.pageBar} ${pagination.numPageBar}
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
        <!--首页面内容结束-->
        <!--首页面尾部开始-->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <!--首页面尾部结束-->
    </body>
</html>
