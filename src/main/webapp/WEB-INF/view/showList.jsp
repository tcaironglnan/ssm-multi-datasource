<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/28
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>显示数据列表的页面</title>
</head>
<br>
<%--oracle数据库数据的显示--%>
<table cellspacing="0" cellpadding="0" border="1">
    <tr>
        <td>姓名</td>
        <td>课程</td>
        <td>分数</td>
    </tr>
    <c:forEach items="${listOracle}" var="one">
        <tr>
            <td>${one.sname}</td>
            <td>${one.kecheng}</td>
            <td>${one.fenshu}</td>
        </tr>
    </c:forEach>
</table>
</br></br>
<%--mysql数据库的数据显示--%>
<table cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td>用户名</td>
        <td>密码</td>
    </tr>
    <c:forEach items="${listMysql}" var="one">
        <tr>
            <td>${one.userName}</td>
            <td>${one.passWord}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
