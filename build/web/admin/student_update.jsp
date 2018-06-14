<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
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
    </head>
    <body>
        <div class="header bg-main">
            <%@include file="/WEB-INF/jspf/admin_top.jspf" %> 
        </div>
        <div class="menu">
            <%@include file="/WEB-INF/jspf/admin_menu.jspf" %> 
        </div>
        <div class="admin">
            <div class="text-center text-main margin-big-bottom"><h2>修改学生记录</h2></div>
            <hr/>
            <form method="get" action="<%= request.getContextPath()%>/Admin/StudentUpdateDo">
                <div class="form-group">
                    <div class="label">
                        <label for="sno">学生学号</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="sno" name="sno" size="50" value="${stu.sno}" readonly />
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="sname">学生姓名</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="sname" name="sname" size="50" value="${stu.sname}" data-validate="required:必填"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="ssex">学生性别</label>
                    </div>
                    <div class="field">
                        <div class="button-group radio">
                            <c:if test="${stu.ssex == '男'}">
                                <label class="button active">
                                    <input name="ssex" value="男" checked="checked" type="radio"><span class="icon icon-male"></span> 男
                                </label>
                                <label class="button">
                                    <input name="ssex" value="女" type="radio"><span class="icon icon-female"></span> 女
                                </label>
                            </c:if>
                            <c:if test="${stu.ssex == '女'}">
                                <label class="button">
                                    <input name="ssex" value="男" type="radio"><span class="icon icon-male"></span> 男
                                </label>
                                <label class="button active">
                                    <input name="ssex" value="女" checked="checked" type="radio"><span class="icon icon-female"></span> 女
                                </label>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="sage">学生年龄</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" id="sage" name="sage" size="50" value="${stu.sage}" data-validate="required:必填,number:年龄只能填写数字,compare#>15:年龄大于15岁,compare#<25:年龄小于25岁"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label for="gid">学生班级</label>
                    </div>
                    <div class="field">
                        <mytag:gradelisttag gid="${stu.grade.gid}"/>
                    </div>
                </div>
                <div class="form-button">
                    <button class="button" type="submit">提交</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
