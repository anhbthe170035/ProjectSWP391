<%-- 
    Document   : doctorList
    Created on : Sep 27, 2024, 2:33:21 AM
    Author     : Haruki
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Bác Sĩ</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
            vertical-align: middle;
        }

        th {
            background-color: #0c64dc;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .important-info {
            color: #d9534f;
            font-weight: bold;
        }

        .button-group {
            display: flex;
            justify-content: space-around;
            align-items: center; 
            height: 100%; 
        }

        .button {
            color: #fff;
            border: none;
            padding: 15px 20px; 
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin: 0 5px; 
            width: 100px;
            height: 95px;
        }

        .add-doctor {
            text-align: right;
        }

        .add-doctor a {
            text-decoration: none;
            color: #fff;
            background-color: #28a745; 
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .add-doctor a:hover {
            background-color: #218838; 
        }

        .button.edit {
            background-color: #ffc107; 
        }

        .button.edit:hover {
            background-color: #e0a800; 
        }

        .button.delete {
            background-color: #dc3545; 
        }

        .button.delete:hover {
            background-color: #c82333; 
        }

        img.doctor-image {
            width: 50px;
            height: auto;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Quản Lý Bác Sĩ</h1>

    <div class="add-doctor">
        <a href="addDoctor">Thêm Bác Sĩ</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên Bác Sĩ</th>
                <th>Chuyên Khoa</th>
                <th>Kinh Nghiệm Làm Việc</th>
                <th>Trình Độ Học Vấn</th>
                <th>Ảnh Đại Diện</th>
                <th>Mô Tả</th>
                <th>Tình Trạng</th>
                <th style="width: 120px;">Hành Động</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listDoctor}" var="d">
              <tr>
                <td class="important-info">${d.doctorID}</td>
                <td class="important-info">${d.name}</td>
                <td class="important-info">${d.departmentId}</td>
                <td class="important-info">${d.workHistoryId}</td>
                <td class="important-info">${d.educationHistoryId}</td>
                <td><img src="${d.portrait}" alt="Doctor" class="doctor-image" /></td>
                <td class="important-info">${d.description}</td>
                <td class="important-info">${d.accountStatus}</td>
                <td class="button-group">
                    <a href="updateDoctor?doctorID=${d.doctorID}" class="button edit">Sửa</a>
                    <a href="deleteDoctor?doctorID=${d.doctorID}" class="button delete">Xóa</a>
                </td>
            </tr>  
            </c:forEach>
        </tbody>
        <form action="doctorList" method="GET">
    <label for="departmentId">Chọn Phòng Ban:</label>
    <select name="departmentId" id="departmentId">
        <option value="">Tất cả</option>
        <option value="1">Phòng Ban 1</option>
        <option value="2">Phòng Ban 2</option>
        <!-- Thêm các tùy chọn khác cho các phòng ban -->
    </select>
    <input type="submit" value="Lọc">
</form>
    </table>
</div>
</body>
</html>
