<%--
  Created by IntelliJ IDEA.
  User: liupengcheng1
  Date: 2016/12/14
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<div style="text-align: center; margin-top: 50px">
    <c:if test="${!empty error}">
        <h2 style="color: red"><c:out value="${error}"></c:out></h2>
    </c:if>

    <form action="<c:url value="/loginCheck.action"/> " method="post">
        用户名：<input type="text" name="userName"><br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="password"><br/><br/>
        <input type="submit" value="登录">
        <input type="button" value="重置">
    </form>
</div>

</body>
</html>
