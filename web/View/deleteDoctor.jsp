<%-- 
    Document   : deleteDoctor
    Created on : Sep 27, 2024, 11:21:40 AM
    Author     : Haruki
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xóa Bác Sĩ - Nhà Thuốc Long Châu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(to right, #00c6ff, #0072ff);
            color: #fff;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #0c64dc;
            margin-bottom: 20px;
            text-align: center;
        }

        .button-group {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }

        .button {
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .confirm {
            background-color: #dc3545; /* Màu đỏ cho xóa */
        }

        .confirm:hover {
            background-color: #c82333; /* Màu đỏ đậm khi hover */
        }

        .cancel {
            background-color: #6c757d; /* Màu xám cho hủy */
        }

        .cancel:hover {
            background-color: #5a6268; /* Màu xám đậm khi hover */
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Xác Nhận Xóa Bác Sĩ</h1>
    
    <form action="${pageContext.request.contextPath}/deleteDoctor" method="post">
        <input type="hidden" name="doctorDetailsID" value="${doctorDetailsID}" />
        <p>Bạn có chắc chắn muốn xóa bác sĩ với ID: <strong>${doctorDetailsID}</strong>?</p>
        
        <div class="button-group">
            <button type="submit" class="button confirm">Xóa</button>
            <a href="doctorList.jsp" class="button cancel">Hủy</a>
        </div>
    </form>
</div>

</body>
</html>
