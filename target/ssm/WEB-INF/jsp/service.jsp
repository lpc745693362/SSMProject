<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>服务调用</title>
</head>
<body>

<div align="center" style="padding:10px">
    <form id="serviceInvokeForm" action="/service/init.action" method="post">
        <c:if test="${!empty error}">
            <h2 style="color: red"><c:out value="${error}"></c:out></h2>
        </c:if>
        <fieldset style="padding:10px; width:70%; border: 1px solid ">
            <legend>
                <font color="#cc3300">
                    <strong>输入服务名称</strong>
                </font>
            </legend>
            <table cellpadding="1" cellspacing="0" align="center" width="100%" border="0" style="font-size:12px;">
                <tr align="left">
                    <td width="10%" height="30" align="right">beanName：</td>
                    <td width="15%"><input type="text" name="beanName" value="${serviceDesc.beanName}" maxlength="30"/></td>
                    <td width="10%" height="30" align="right">方法名：</td>
                    <td width="15%"><input type="text" name="methodName" value="${serviceDesc.methodName}" maxlength="30"/></td>
                    <td width="65%" align="left"><input type="submit" value="提&nbsp;交" style="cursor:pointer"/></td>
                </tr>
            </table>
        </fieldset>

        <c:if test="${serviceDesc.params.size() > 0}">
            <c:forEach var="param" items="${serviceDesc.params}" varStatus="status">
                <input type="hidden" id="params[${status.index}].value" name="params[${status.index}].value" />
            </c:forEach>
        </c:if>

    </form>


    <c:if test="${serviceDesc.params.size() > 0}">
        <fieldset style="padding:10px; width:70%; border: 1px solid ">
            <legend>
                <font color="#cc3300">
                    <strong>输入参数</strong>
                </font>
            </legend>

            <c:forEach var="mParam" items="${serviceDesc.params}" varStatus="status">
                <form id="paramForm${status.index}" action="" method="post">
                    <c:choose>
                        <c:when test="${mParam.fields.size() > 0}">
                            <fieldset style="padding:10px; width:90%; border: 1px solid">
                                <legend>
                                    <font color="#cc3300">
                                        <strong>${mParam.name}</strong>
                                    </font>
                                </legend>
                                <table cellpadding="1" cellspacing="0" align="center" width="100%" border="0" style="font-size:12px;">
                                    <tr align="left">
                                        <c:forEach var="field" items="${mParam.fields}">
                                            <td width="10%" height="30" align="right">${field.name}：</td>
                                            <td width="15%"><input type="text" name="${field.name}" value="${field.value}" maxlength="30"/></td>
                                        </c:forEach>
                                    </tr>
                                </table>
                            </fieldset>
                        </c:when>
                        <c:otherwise>
                            <table cellpadding="1" cellspacing="0" align="center" width="90%" border="0" style="font-size:12px;">
                                <tr>
                                    <td width="15%" height="30" align="left"><font color="#cc3300"><strong>${mParam.name}</strong> </font> ：</td>
                                    <td width="85%" align="left"><input type="text" name="${mParam.name}" value="${mParam.value.replace("\"", "")}" maxlength="30"/></td>
                                </tr>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </form>
            </c:forEach>

            <div width="65%" align="center"><input type="button" id="invokeService" onclick="serviceSubmit();" value="执&nbsp;行" style="cursor:pointer"/></div>

        </fieldset>
    </c:if>

    <fieldset style="padding:10px; width:70%; border: 1px solid">
        <legend>
            <font color="#cc3300">
                <strong>执行结果</strong>
            </font>
        </legend>

        <table cellpadding="1" cellspacing="0" align="center" width="90%" border="0" style="background-color:white">
            <tr align="center">
                <td width="80%">
	            <textarea style="font-size:12px;width:1000px; height:100px;overflow:auto;">
                    ${serviceDesc.jsonResult}
                </textarea>
                </td>
            </tr>
        </table>
    </fieldset>

</div>

</body>
</html>

<script type="text/javascript">

    function serviceSubmit() {
        var count = ${serviceDesc.params.size()};
        for (var i = 0; i < count; i++) {
            var json = $("#paramForm" + i).serializeObject();
            document.getElementById("params[" + i + "].value").value = JSON.stringify(json);
        }
        $("#serviceInvokeForm").attr("action", "/service/invokeService.action");
        $("#serviceInvokeForm").submit();
    }

    jQuery.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        if (a.length == 1) {
            return a[0].value;
        }
        jQuery.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                if (this.value != '') {
                    o[this.name].push(this.value || '');
                }
            } else {
                if (this.value != '') {
                    o[this.name] = this.value || '';
                }
            }
        });
        return o;
    };

</script>

