<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <p>${user.userName}</p>
    <p><fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
</div>
<a href="/print">打印</a>
<a href="/user/1/info">用户信息</a>
</body>
</html>
