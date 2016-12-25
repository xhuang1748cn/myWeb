<%--
  Created by IntelliJ IDEA.
  User: SRn
  Date: 2016/12/25
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="ttd" uri="http://cn.srn/jsp/TagDemo"%>
<!DOCTYPE html>
<html>
<head>
    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <p>tagTest</p>
    <ttd:jspTagTest tagProperty="${fileType}">
        您好，幸运密码是 oooxxx ！
    </ttd:jspTagTest>
</body>
</html>