<%--
  Created by IntelliJ IDEA.
  User: liupengcheng1
  Date: 2016/12/14
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <div style="text-align: center; margin-top: 50px">
        <h2>${user.userName}，欢迎您登录成功，您当前积分为${user.credits}。</h2>
    </div>
</body>
</html>
