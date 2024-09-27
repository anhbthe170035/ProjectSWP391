<%-- 
    Document   : Menu
    Created on : Sep 27, 2024, 2:50:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Menu -->
<nav class="navbar navbar-expand-md navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Nhà Thuốc Long Châu</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="manager">Quản lý Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Bài viết sức khỏe</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tư vấn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên hệ</a>
                </li>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${ValueOfSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Tìm kiếm thuốc...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="show">
                    <i class="fa fa-shopping-cart"></i> Giỏ hàng
                    <span class="badge badge-light">3</span>
                </a>
            </form>

            <c:if test="${sessionScope.user == null}">
                <form class="form-inline my-2 my-lg-0">
                    <a class="btn btn-outline-success my-2 my-sm-0 btn-nav" href="login.jsp">Đăng nhập</a>
                    <a class="btn btn-outline-success my-2 my-sm-0 btn-nav" href="register.jsp">Đăng ký</a>
                </form>
            </c:if>

            <c:if test="${sessionScope.user != null}">
                <form class="form-inline my-2 my-lg-0">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${sessionScope.user.username}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="profile.jsp">Profile</a>
                            <a class="dropdown-item" href="changepwd">Change Password</a>
                            <a class="dropdown-item" href="logout">Logout</a>
                        </div>
                    </div>
                </form>
            </c:if>
        </div>
    </div>
</nav>
<!-- Banner -->
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Nhà Thuốc Chính Hãng - Uy Tín Chất Lượng</h1>
        <p class="lead text-muted mb-0">Chăm sóc sức khỏe gia đình bạn với những sản phẩm tốt nhất từ các hãng dược hàng đầu.</p>
    </div>
</section>
