<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
<h2>Hello World!</h2>
<div>
    <p>${user.userName}</p>
    <p><fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
</div>
<a href="/user/1/info">用户信息</a>
</body>
</html>
