<%-- 
    Document   : addDoctor
    Created on : Sep 27, 2024, 2:47:26 AM
    Author     : Haruki
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Bác Sĩ - Quản Lý Bệnh Viện</title>
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
            max-width: 600px;
            margin: auto;
        }

        h1 {
            color: #0c64dc;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
            color: #333;
        }

        input[type="text"], input[type="number"], textarea, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            color: #333;
        }

        textarea {
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #28a745; 
            color: #fff; 
            padding: 10px 20px; 
            border: none; 
            border-radius: 5px; 
            cursor: pointer; 
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #218838; 
        }

    </style>
</head>
<body>

<div class="container">
    <h1>Thêm Bác Sĩ</h1>
    <form action="${pageContext.request.contextPath}/addDoctor" method="post">
        <div class="form-group">
            <label for="doctorName">Tên Bác Sĩ</label>
            <input id="doctorName" name="doctorName" type="text" required>
        </div>
        <div class="form-group">
            <label for="portrait">Ảnh Chân Dung</label>
            <input id="portrait" name="portrait" type="text" required>
        </div>
        <div class="form-group">
            <label for="description">Mô Tả Ngắn</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="workHistoryID">Lịch Sử Công Tác </label>
            <input id="workHistoryID" name="workHistoryID" type="number" required>
        </div>
        <div class="form-group">
            <label for="educationHistoryID">Lịch Sử Giáo Dục </label>
            <input id="educationHistoryID" name="educationHistoryID" type="number" required>
        </div>
        <div class="form-group">
            <label for="department">Chuyên Khoa</label>
            <select id="department" name="department" class="form-select" aria-label="Default select example">
                <c:forEach items="${ListDepartment}" var="d">
                    <option value="${d.departmentID}">${d.departmentName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="accountStatus">Trạng Thái Tài Khoản</label>
            <select id="accountStatus" name="accountStatus" required>
                <option value="active">Hoạt Động</option>
                <option value="inactive">Không Hoạt Động</option>
            </select>
        </div>
        <input type="submit" value="Thêm Bác Sĩ">
    </form>
</div>

</body>
</html>
