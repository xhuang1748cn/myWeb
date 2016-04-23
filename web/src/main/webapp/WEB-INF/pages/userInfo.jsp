<%--
  Created by IntelliJ IDEA.
  User: SRn
  Date: 2016/4/23
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/jquery-confirm/jquery-confirm.css"/>
    <script src="js/jquery/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/jquery-confirm/jquery-confirm.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
</head>
<body>
    <div>
        <p>${user.userName}</p>
        <p><fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
    </div>
</body>
</html>
