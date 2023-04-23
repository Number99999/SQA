
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý kho hàng</title>
        
        <style>
            body {
                background-color: #f5f5f5;
                font-family: Arial, sans-serif;
                font-size: 16px;
                margin: 0;
                padding: 0;
            }
            
            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }
            
            h1 {
                font-size: 36px;
                font-weight: bold;
                margin-top: 0;
            }
            
            nav {
                background-color: #333;
                color: #fff;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 20px;
            }
            
            nav a {
                color: #fff;
                font-weight: bold;
                text-decoration: none;
                margin-left: 30px;
                height: 30px;
            }
            
            nav a:first-child {
                margin-left: 0;
            }
            
            main {
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
                margin-top: 20px;
                padding: 20px;
            }
            
            footer {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 20px;
                bottom: 0;
                position: absolute;
                height: fit-content;
                width: -webkit-fill-available;
            }
            
            footer p {
                margin: 0;
            }
        </style>
    </head>
    <body>
        <nav>
            
            <div>
                <a href="${pageContext.request.contextPath}/products">Quản lý mặt hàng</a>
                <a href="${pageContext.request.contextPath}/bills">Nhập hàng</a>
                <a href="${pageContext.request.contextPath}/login.jsp">Đăng xuất</a>
            </div>
        </nav>
        <main class="container">
            <h1>Quản lý kho hàng</h1>
            <p>Chào mừng đến với ứng dụng quản lý kho hàng.</p>
        </main>
            <footer>
            <p>&copy; 2023, G5-N20.</p>
        </footer>
    </body>
</html>
