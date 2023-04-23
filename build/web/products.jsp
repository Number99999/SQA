<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Quản lý sản phẩm</title>
        <style type="text/css">
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
            height: 18px;
        }
        h1 {
            margin-top: -10px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ccc;
            text-align: left;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
            cursor: pointer;
        }
        .container {
            display: grid;
            grid-template-columns: 1fr 1fr;
            padding: 20px;
            grid-gap: 20px;
        }
        .tab {
            padding-left: 50px;
        }
        .button {
            display: inline-block;
            border-radius: 4px;
            background-color: #f44336;
            color: #fff;
            text-align: center;
            padding: 8px;
            margin: 4px 2px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #d63028;
        }
    </style>
        
    </head>
    <body>
    <header>
        <h1 >Quản lý sản phẩm</h1>
    </header>
    
    <div class="container">
        <table id="table1">
            <tr>
                <th>Mã mặt hàng</th>
                <th>Tên mặt hàng</th>
                <th>Giá nhập</th>
                <th>Giá bán</th>
                <th>Loại</th>
                <th>Thao tác</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.ma}</td>
                    <td>${product.ten}</td>
                    <td>${product.gianhap}</td>
                    <td>${product.giaban}</td>
                    <td>${product.loai}</td>
                    <td>
                        <a class="button" href="<c:url value='/edit?action=update&productCode=${product.ma}'/>">Sửa</a>
                        <a class="button" href="<c:url value='/delete?productCode=${product.ma}'/>">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div style="margin-top: 20px; text-align: center;">
        <a class="button" href="<c:url value='/edit?action=create'/>">Thêm mặt hàng</a>
        <a class="button" href="${pageContext.request.contextPath}/index.jsp">Trang chủ</a>
    </div>
</body>
