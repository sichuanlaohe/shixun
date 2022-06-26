<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 何宇航 在郫都
  Date: 2022/6/22
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%

    List<Student> stus=(List<Student>)request.getAttribute("stus");

    for(Student stu:stus){
        %>

<%=stu.no+stu.name%>
<br>

<%
    }
%>

</body>
</html>
