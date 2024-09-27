<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Account Management Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-wrapper {
            margin: 20px auto;
            max-width: 1200px;
        }
        .page-header {
            margin: 20px 0;
        }
        .search-bar {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 10px;
        }
        .options-col {
            text-align: center;
        }
        .btn-options {
            margin-right: 5px;
        }
        .btn-options:last-child {
            margin-right: 0;
        }
        .pagination {
            justify-content: center;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-between align-items-center page-header">
            <h2>Staff Account Management Page</h2>
            <div class="d-flex align-items-center">
                <p class="mb-0 mr-3">Hi, Admin</p>
                <button class="btn btn-outline-secondary">Logout</button>
            </div>
        </div>

        <!-- Menu -->
        <ul class="nav nav-tabs mb-3">
            <li class="nav-item">
                <a class="nav-link active" href="#">Staff Account List</a>
            </li>
        </ul>

        <!-- Search bar -->
        <div class="search-bar">
            <input type="text" class="form-control w-25" placeholder="Search staffs">
            <button class="btn btn-outline-secondary ml-2">Search</button>
        </div>

        <!-- Table -->
        <div class="table-wrapper">
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>Staff ID</th>
                        <th>Staff Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Roles</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.phoneNumber}</td>
                            <td>${user.role.roleName}</td>
                            <td class="options-col">
                                <div class="d-flex justify-content-center align-items-center">
                                    <!-- Nút Update -->
                                    <a href="update-user?id=${user.userId}" class="btn btn-info btn-options">Update</a>
                                    <!-- Nút Delete với modal xác nhận -->
                                    <button class="btn btn-danger btn-options" data-toggle="modal" data-target="#confirmDeleteModal" data-userid="${user.userId}">Delete</button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Add Staff Link -->
            <a href="create-user" class="text-primary">+ Add Staff</a>

            <!-- Pagination -->
            <!-- (Giữ nguyên phần phân trang nếu bạn đã có) -->

        </div>
    </div>

    <!-- Modal xác nhận xóa -->
    <div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Xác nhận xóa</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            Bạn có chắc chắn muốn xóa nhân viên này không?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
            <a href="#" id="confirmDeleteButton" class="btn btn-danger">Xóa</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap JS và JQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Script để xử lý sự kiện khi mở modal -->
    <script>
        $('#confirmDeleteModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Nút nhấn mở modal
            var userId = button.data('userid'); // Lấy userId từ thuộc tính data-userid
            var modal = $(this);
            var deleteUrl = 'delete-user?userId=' + userId; // Đường dẫn đến servlet xóa

            // Cập nhật href cho nút xác nhận xóa
            modal.find('#confirmDeleteButton').attr('href', deleteUrl);
        });
    </script>
</body>
</html>
