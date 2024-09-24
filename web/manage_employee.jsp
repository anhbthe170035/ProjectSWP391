<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

        .pagination {
            justify-content: center;
        }
    </style>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
            <button class="btn btn-outline-secondary ml-2">?</button>
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
                        <th>Rules</th>
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
                           <td>
        ${user.role.roleName}
</td>
                            <td class="options-col">
    <a href="update_employee.jsp?userId=${user.userId}" class="btn btn-info btn-options">U</a>
    <button class="btn btn-danger btn-options">D</button>
    <button class="btn btn-secondary btn-options">V</button>
</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Add Staff Link -->
            <a href="create_employee.jsp" class="text-primary">+ Add Staff</a>

            <!-- Pagination -->
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#"><<</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#"><</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">1</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">...</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">99</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">>></a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

    <!-- Bootstrap JS và JQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
