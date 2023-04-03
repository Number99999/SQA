<%-- 
    Document   : login
    Created on : Mar 29, 2023, 7:51:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Đăng nhập</h2>
        <form action="login" method="get">
            <label for="username">Tên đăng nhập:</label><br>
            <input type="text" id="username" name="username" required ><br>
            <label for="password">Mật khẩu:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <c:if test="${error != null}">
                <div style="color: red">${error}</div>
            </c:if>
            <button type="submit" >Dang Nhap</button> 
        </form> 
    </body>
</html>
