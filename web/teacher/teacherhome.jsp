<%-- 
    Document   : teacherHome
    Created on : Jun 1, 2022, 7:58:43 AM
    Author     : Windows 10 TIMT
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="teacher/css/teacherhome.css">
        <!-- Thay KIT o day-->
        <script src="https://kit.fontawesome.com/67b5c45612.js" crossorigin="anonymous"></script>
        <script src="js/teacherhome.js"></script>

    </head>

    <body>
        <div class="wrapper">
            <div class="home">
                <div class="left-side-menu">
                    <div class="vertical-menu">
                        <div class="user-welcome">
                            <c:set var="teacher" value="${sessionScope.teacher}" />
                            <img class="user-img" src="teacher/img/userImg/dummy-user-img.png" style="width: 80px; height: 80px;" alt="">
                            <p>${teacher.last_name}</p>
                        </div>
                        <div class="menu-item-container">
                            <ul class="item-lists">
                                <li class="menu-item current1">
                                    <a href="#">Home</a>
                                </li>
                                <li class="menu-item">
                                    <a href="teacher/schedule.jsp">View schedule</a>
                                </li>
                            </ul>
                        </div>
                        <div class="log-out">
                            <a href="login?action=logout">Log out</a>
                        </div>
                    </div>
                </div>

                <div class="right-side">
                    <div class="page-content">
                        <div class="header-container">
                            <div class="header-intro">
                                <div class="class-section">
                                    <h1>${kinder_class.class_name}</h1>
                                </div>
                                <div class="search-section">
                                    <form>
                                        <input type="search" placeholder="Search...">
                                        <button type="submit">Search</button>
                                    </form>
                                </div>
                            </div>
                            <div class="header-filter">
                                <div class="left-modes">
                                    <div class="check-section">
                                        <div class="check-in check-item">
                                            <a href="">Check in</a>
                                        </div>
                                        <div class="check-out check-item">
                                            <a href="">Check out</a>
                                        </div>
                                    </div>
                                    <div class="student-filter">
                                        <div class="filter-item">
                                            <a href="">All</a>
                                        </div>
                                        <div class="filter-item">
                                            <a href="">Absent only</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="mode-menu right-mode">
                                    <a href="#" class="window-mode mode-item current1">
                                        <img src="teacher/img/icon/372745201553239377-128.png" style="width: 33px; height: 35px; line-height: 32px;" alt="">
                                    </a>
                                    <a href="attendance" class="list-mode mode-item " style="text-decoration: none;">
                                        <i class="fa-solid fa-bars" style="font-size: 25px; line-height: 35px;"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="body-container">
                            <form action="attendance" method="POST">
                                <div class="list-students">
                                    <c:forEach items="${requestScope.listStudent}" var="student">
                                        <div href="kidprofile?kid_id=${student.kinder_id}" class="student-infor">
                                            <div class="img-section">
                                                <img src="teacher/img/userImg/download.png" alt="">
                                            </div>
                                            <a>${student.first_name} ${student.last_name}</a>
                                            <div class="check-attendence">
                                                <input type="radio" name="checkAttendence${student.kinder_id}" value="1" placeholder="Attend"> Attend
                                                <input type="radio" name="checkAttendence${student.kinder_id}" value="0" placeholder="Absent"> Absent
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="submit-btn">
                                    <input type="submit" name="Save" value="Save"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script>
        window.onload = function () {
            var patharr = location.pathname.split("/");
            var fileName = patharr[1];
            var options = document.getElementById('options');
            var links = options.getElementsByTagName("a");
            // alert(links.length);
            for (i = 1; i < links.length; i++) {
                if (links[i].getAttribute("href").indexOf(fileName) > -1) {
                    links[i].parentNode.className = 'current';
                }
            }
        };
    </script>
</html>
