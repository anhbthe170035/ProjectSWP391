<%-- 
    Document   : updateDoctor
    Created on : Sep 27, 2024, 12:09:15 PM
    Author     : Haruki
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Doctor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px gray;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], select, textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Doctor</h2>

        <!-- Thông báo lỗi hoặc thành công -->
        <c:if test="${not empty errorMessage}">
            <div style="color: red; text-align: center;">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div style="color: green; text-align: center;">${successMessage}</div>
        </c:if>

        <!-- Form cập nhật thông tin bác sĩ -->
        <form action="${pageContext.request.contextPath}/updateDoctor" method="post">
            <input type="hidden" name="doctorID" value="${doctor.doctorID}" />

            <!-- Tên bác sĩ -->
            <label for="doctorName">Doctor Name:</label>
            <input type="text" id="doctorName" name="doctorName" value="${doctor.userID}" required />

            <!-- Phòng ban -->
            <label for="department">Department:</label>
            <select id="department" name="department">
                <c:forEach var="department" items="${ListDepartments}">
                    <option value="${department.departmentID}" ${doctor.departmentID == department.departmentID ? 'selected' : ''}>
                        ${department.departmentName}
                    </option>
                </c:forEach>
            </select>

            <!-- Lịch sử công việc -->
            <label for="workHistoryID">Work History ID:</label>
            <input type="text" id="workHistoryID" name="workHistoryID" value="${doctor.workHistoryID}" required />

            <!-- Lịch sử học vấn -->
            <label for="educationHistoryID">Education History ID:</label>
            <input type="text" id="educationHistoryID" name="educationHistoryID" value="${doctor.educationHistoryID}" required />

            <!-- Mô tả -->
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="5" required>${doctor.description}</textarea>

            <!-- Trạng thái tài khoản -->
            <label for="accountStatus">Account Status:</label>
            <select id="accountStatus" name="accountStatus">
                <option value="active" ${doctor.isActive ? 'selected' : ''}>Active</option>
                <option value="inactive" ${!doctor.isActive ? 'selected' : ''}>Inactive</option>
            </select>

            <!-- Nút Submit -->
            <input type="submit" value="Update Doctor">
        </form>
    </div>
</body>
</html>

