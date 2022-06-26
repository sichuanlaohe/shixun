<%--
  Created by IntelliJ IDEA.
  User: 何宇航
  Date: 2022/6/23
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    user: <input type="text" name="user"><br>
    password <input type="text" name="password"><br>
    <input type="submit" value="提交" >
</form>
</body>
</html>
