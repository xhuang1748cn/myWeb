<%--
  Created by IntelliJ IDEA.
  User: SRn
  Date: 2016/12/25
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>
    <base href="${pageContext.request.contextPath}/"/>
    <script src="/js/sockjs/sockjs.js"></script>

    <script type="text/javascript">
        /*var  wsServer = 'ws://127.0.0.1:8080/test/hello';
         var  websocket = new WebSocket(wsServer);
         websocket.onopen = function (evt) { onOpen(evt) };
         websocket.onclose = function (evt) { onClose(evt) };
         websocket.onmessage = function (evt) { onMessage(evt) };
         websocket.onerror = function (evt) { onError(evt) };
         function onOpen(evt) {
         console.log("Connected to WebSocket server.");
         }
         function onClose(evt) {
         console.log("Disconnected");
         }
         function onMessage(evt) {
         console.log('Retrieved data from server: ' + evt.data);
         }
         function onError(evt) {
         console.log('Error occured: ' + evt.data);
         }*/

        var sock = new SockJS('http://localhost:8080/hello');
        sock.onopen = function() {
            console.log('open');
            sock.send('test');
            console.log('send ...');
            setTimeout(function(){sock.send('later');},3000);
        };
        sock.onmessage = function(e) {
            console.log('message', e.data);
        };
        sock.onclose = function() {
            console.log('close');
        };

        function closeSock() {
            sock.close();
        }
    </script>
</head>
<body>
    <p>testSocket</p>
    <button onclick="closeSock();">关闭socket</button>
</body>
</html>