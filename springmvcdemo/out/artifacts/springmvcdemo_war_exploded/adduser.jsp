<%--
  Created by IntelliJ IDEA.
  User: 10715
  Date: 2022/1/11 0011
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/adduser">
    用户姓名：<input type="text" name="username">
    爱好：<br>
    体育：<input type="checkbox" value="sport" name="userlike">
    音乐：<input type="checkbox" value="music" name="userlike">
    艺术：<input type="checkbox" value="art" name="userlike"><br>
    地址：<br>
    电话：<input type="text" name="address.phonenumber">
    邮编：<input type="text" name="address.postcode">
    <input type="submit" value="OK"/>
</form>
</body>
</html>
