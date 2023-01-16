<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error Messeage</title>
</head>
<body>
<h1>Tính năng hiện đang bảo trì, vui lòng đừng thử lại</h1>
<a href="<%=request.getContextPath()%>/index.jsp"><button>Go Back</button></a>
<style>
  h1,a{
    border: 3px solid black;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%)
  }
  a{
    margin-top: 80px;
  }
</style>
</body>
</html>