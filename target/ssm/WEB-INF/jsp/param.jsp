<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>参数传递</title>
</head>
<body>

<div style="text-align: center">

    <h1>submitUserList</h1>
    <input id="submit" type="button" value="提交" onclick="submitUserList();">

</div>

<script type="text/javascript">

    // 将Json对象序列化成Json字符串提交，以List接收
    function submitUserList() {
        var userArray = new Array();
        userArray.push({"userId": "1000", "userName": "root"});
        userArray.push({"userId": "1001", "userName": "adou"});
        userArray.push({"userId": "1002", "userName": "liupc"});
        $.ajax({
            url: "/param/list.action",
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(userArray),
            success: function (result) {
                alert(result);
            },
            error: function (res) {
                alert(res.responseText)
            }
        });
    }

</script>

</body>
</html>
