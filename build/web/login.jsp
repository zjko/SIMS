<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息管理系统-登录</title>
        <link rel="stylesheet" href="css/pintuer.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
        <c:if test="${!(empty message)}">
            <script type="text/javascript">
            alert('<c:out value="${message}"/>');
            </script>
            <c:remove var="message" scope="session"/>
        </c:if>
    </head>
    <body>
        <div align="center" style="margin-top: 100px;">
            <form action="Admin/AdminLogin" method="post">
                <div class="panel padding" style="width: 450px;text-align: left;">
                    <div class="text-center">
                        <br>
                        <h2><strong>欢迎使用学生信息管理系统</strong></h2></div>
                    <div class="" style="padding:30px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                                <span class="icon icon-user"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                                <span class="icon icon-key"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <button class="button button-block bg-main text-big">立即登录</button>
                            </div>
                        </div>
                        <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图</a> 版权所有</div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
