<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Quản lý sản phẩm</title>
        <style type="text/css">
            table, th, td {
                border: 1px solid #ccc;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 10px;
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
            }
            h1 {
                margin-top: 0;
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
        <h1>Tất cả sản phẩm</h1>
        <h1>Hóa đơn</h1>
        <div class="container">
            <table id="table1" class="table">
                <thead>
                    <tr>
                        <th>Mã mặt hàng</th>
                        <th>Tên mặt hàng</th>
                        <th>Giá nhập</th>
                        <th>Giá bán</th>
                        <th>Loại</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.ma}</td>
                            <td>${product.ten}</td>
                            <td>${product.gianhap}</td>
                            <td>${product.giaban}</td>
                            <td>${product.loai}</td>
                            <td><a class='button' href="<c:url value="/bills?productCode=${product.ma}"/>">Chọn</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form method="post" action="bills">
                <table id="table2" class="table">
                    <thead>
                        <tr>
                            <th>Mã mặt hàng</th>
                            <th>Tên mặt hàng</th>
                            <th>Giá nhập</th>
                            <th>Loại</th>
                            <th>Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" id="ma" name="ma" value="${hoadon.ma}" readonly style="border:none; width: 50px"/></td>
                            <td>${hoadon.ten}</td>
                            <td>${hoadon.gianhap}</td>
                            <td>${hoadon.loai}</td>
                            <td><input type="number" id="soluong" name="soluong" style="border:none; width: 70px;" required/></td>
                        </tr>
                    </tbody>
                </table>
                <button type="submit"  formaction="/quanlimathang/bills?ma=${hoadon.ma}">Hoàn tất</button>
            </form>
        </div>
        <div style="margin-top: 10px">
            <a class="button" href="<c:url value='/edit?action=create'/>">Thêm mặt hàng</a>
            <a class="button" href="${pageContext.request.contextPath}/index.jsp">Trang chủ</a><!-- Comment -->
        </div>
    </body>