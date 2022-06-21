<%-- 
    Document   : schedule
    Created on : Jun 1, 2022, 8:03:09 AM
    Author     : Windows 10 TIMT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/67b5c45612.js" crossorigin="anonymous"></script>
        <title>Document</title>
        <link rel="stylesheet" href="teacher/css/teacherhome.css">
        <link rel="stylesheet" href="teacher/css/schedule.css">
        <style>
            
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="home">
                <div class="left-side-menu">
                    <div class="vertical-menu">
                        <div class="user-welcome">
                            <img class="user-img" src="teacher/img/userImg/dummy-user-img.png" style="width: 80px; height: 80px;" alt="">
                            <p>Harry Porter</p>
                        </div>
                        <div class="menu-item-container">
                            <ul class="item-lists">
                                <li class="menu-item">
                                    <a href="../teacherhome">Home</a>
                                </li>

                                <li class="menu-item current1">
                                    <a href="schedule.jsp">View schedule</a>
                                </li>
                                <li class="menu-item">
                                    <a href="studenlist.jsp">View student</a>
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
                                    <h1>SE1608</h1>
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
                                    <div class="year-selection">
                                        <select name="" id="" class="year">
                                            <option value="">2019</option>
                                            <option value="">2020</option>
                                            <option value="">2021</option>
                                            <option value="">2022</option>
                                        </select>
                                        <i class="fa-solid fa-circle-chevron-down"></i>
                                    </div>
                                    <div class="date-selection">

                                    </div>
                                </div>
                                <div class="mode-menu right-mode">
                                    <div class="window-mode mode-item">
                                        <img src="teacher/img/icon/372745201553239377-128.png" style="width: 33px; height: 35px; line-height: 32px;" alt="">
                                    </div>
                                    <div class="list-mode mode-item">
                                        <i class="fa-solid fa-bars" style="font-size: 25px; line-height: 35px;"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="schedule-content">
                                <table>
                                    <thead>
                                        <tr>
                                            <td>Mon</td>
                                            <td>Tue</td>
                                            <td>Wed</td>
                                            <td>Thu</td>
                                            <td>Fri</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                        <tr>
                                            <td>Lunch Break</td>
                                            <td>Lunch Break</td>
                                            <td>Lunch Break</td>
                                            <td>Lunch Break</td>
                                            <td>Lunch Break</td>
                                        </tr>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                        <tr>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                            <td>Physical education </br> <span>08:00 - 09:00</span></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
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