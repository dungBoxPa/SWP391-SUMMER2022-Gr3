hh<%-- 
    Document   : login
    Created on : May 30, 2022, 9:12:30 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Đăng nhập
        <br/>
        <form action="login" method="POST">
            <input type="text" name="email" placeholder="Email của bạn" /><br />
            <input type="password" name="password" placeholder="Nhập mật khẩu" /><br /><br />
            <input type="submit" value="ĐĂNG NHẬP"><br/>
        </form>
        ${error}
        <form action="register" method="POST">
            <input type="text" name="fname" placeholder="Tên" /><br />
            <input type="text" name="lname" placeholder="Họ" /><br />
            <input type="radio" name="gender" checked value = "male" /> Male <br />
            <input type="radio" name="gender" value = "female" /> Female <br />
            <input type="text" name="address" placeholder="Địa chỉ" /><br />
            <input type="text" name="phone" placeholder="Số điện thoại" /><br />
            <input type="text" name="email" placeholder="Email của bạn" /><br />
            <input type="date" name="dob"" /><br />
            <input type="text" name="img" placeholder="Link ảnh của bạn" /><br />
            <input type="password" name="password" placeholder="Nhập mật khẩu" /><br /><br />
            <input type="submit" value="ĐĂNG KÝ"><br/>
        </form>
    </body>
</html>
