<%-- 
    Document   : checkPassword
    Created on : Sep 27, 2024, 5:52:45 PM
    Author     : Haruki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <title>Login | Tech World</title>
        
    </head><!--/head-->



    <body>
        <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="login-form"><!--login form-->
                            <h2>Đặt lại mật khẩu</h2>
                            <form action="${pageContext.request.contextPath}/updatePass" method="POST">
                            <!-- Input for New Password -->
                            <div class="form-group">
                                <label for="newPassword">Mật khẩu mới:</label>
                                <input type="password" class="form-control" id="newPassword" name="newPassword" required />
                            </div>

                            <!-- Input for Confirm New Password -->
                            <div class="form-group">
                                <label for="confirmPassword">Nhập lại mật khẩu:</label>
                                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required />
                            </div>
                            <button type="submit" class="btn btn-default">Thay đổi</button>
                            <b style="color: #1E90FF">${mess}</b>                          
                            <b style="color: red">${error}</b>

                        </form>
                    </div><!--/login form-->
                </div>
            </div>
        </div>

</html>
