<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="renderer" content="webkit">
        <title>后台管理中心</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/pintuer.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/admin.css">
        <script src="<%= request.getContextPath()%>/js/jquery.js"></script>
        <script src="<%= request.getContextPath()%>/js/pintuer.js"></script>
        <style>
            .table td{vertical-align: middle;}
        </style>
    </head>
    <body>
        <div class="header bg-main">
            <%@include file="/WEB-INF/jspf/admin_top.jspf" %> 
        </div>
        <div class="menu">
            <%@include file="/WEB-INF/jspf/admin_menu.jspf" %> 
        </div>
        <div class="admin">
            <div class="table-responsive">
                <div class="text-center text-main margin-big-bottom"><h2>显示所有学生记录</h2></div>
                <form method="post" action="<%= request.getContextPath()%>/Admin/StudentManage">
                    <div class="form-group">
                        <div class="field">
                            <div class="input-group">
                                <span class="addbtn">
                                    <button type="button" class="button icon-search"></button>
                                </span>
                                <input type="text" class="input" name="keywords" size="30" placeholder="请输入要搜索的学号" />
                                <span class="addbtn"><button type="button" class="button">搜索</button></span>
                            </div>
                        </div>
                    </div>
                </form>
                <table class="table table-bordered">
                    <tr>
                        <td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>班级名称</td><td>入学年份</td><td>专业名称</td><td>专业负责人</td>
                        <td>功能操作</td>
                    </tr>
                    <c:forEach var="stu" items="${students}">
                        <tr>
                            <td>${stu.sno}</td><td>${stu.sname}</td><td>${stu.ssex}</td><td>${stu.sage}</td><td>${stu.grade.gname}</td><td>${stu.grade.year}</td><td>${stu.grade.major.mname}</td><td>${stu.grade.major.director}</td>
                            <td>
                                <a class="button button-small border-red" href="<%=request.getContextPath()%>/Admin/StudentDelete?sno=${stu.sno}">删除</a> | 
                                <a class="button button-small border-main" href="<%=request.getContextPath()%>/Admin/StudentUpdate?sno=${stu.sno}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="text-center margin-big-top height-big">
                ${pagination.pageBar} &nbsp;&nbsp; ${pagination.numPageBar} &nbsp;&nbsp; 
                <a class="button button-small border-main" href="<%=request.getContextPath()%>/admin/student_add.jsp">添加学生记录</a>
            </div>
        </div>
    </div>
</body>
</html>
