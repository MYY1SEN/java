<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/10/9
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

<h3>用户登陆</h3>
<form action="login" method="post">

    <p>
        用户名：<input type="text" name="username"/>${msg}
    </p>
    <p>
        密码：<input type="text" name="password"/>
    </p>
    <p>
        <input type="submit" value="提交"/>
    </p>

</form>

</body>
</html>
