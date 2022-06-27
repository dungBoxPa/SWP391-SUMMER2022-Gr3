<%-- 
    Document   : feedback
    Created on : Jun 1, 2022, 8:02:42 AM
    Author     : Windows 10 TIMT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="teacher/css/teacherhome.css">
        <link rel="stylesheet" href="teacher/css/kidprofile.css">
        <link rel="stylesheet" href="teacher/css/feedback.css">
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
                                    <a href="loadteacherhome">Home</a>
                                </li>
                                <li class="menu-item">
                                    <a href="#">View schedule</a>
                                </li>
                                <li class="menu-item current1">
                                    <a href="#" style="color: #fff;">View student</a>
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
                        <div class="kid-profile">
                            <div class="kid-profile_header">
                                <div class="img-section">
                                    <img src="teacher/img/userImg/dummy-user-img.png" alt="">
                                </div>

                                <div class="personel-section">
                                    <h1>Andrew</h1>
                                    <p>01-01-1999</p>
                                </div>
                            </div>

                            <div class="list-option" id="options">
                                <div class="attendence option-item">
                                    <a href="studentinfor?action=attendance">Attendance</a>
                                </div>
                                <div class="feedback option-item">
                                    <a href="#">Feedback</a>
                                </div>
                                <div class="profile option-item">
                                    <a href="kidprofile?kid_id=${requestScope.kid_id}">Profile</a>
                                </div>
                            </div>
                            <form action="feedback" method="POST">
                                <c:set var="kid_id" value="${requestScope.kid_id}"/>
                                <input type="hidden" name="kid_id" value="${kid_id}" readonly />
                                <div class="feedback-content">
                                    <textarea name="fb-content" id="" cols="30" rows="10" placeholder="Type feedback..."></textarea>
                                </div>
                                <div class="feedback-section">

                                    <div class="feedback-section-content">
                                        <div id="rating">
                                            <input type="radio" id="star5" name="rating" value="5" />
                                            <label class="full" for="star5" title="Awesome - 5 stars"></label>

                                            <input type="radio" id="star4half" name="rating" value="4.5" />
                                            <label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>

                                            <input type="radio" id="star4" name="rating" value="4" />
                                            <label class="full" for="star4" title="Pretty good - 4 stars"></label>

                                            <input type="radio" id="star3half" name="rating" value="3.5" />
                                            <label class="half" for="star3half" title="Meh - 3.5 stars"></label>

                                            <input type="radio" id="star3" name="rating" value="3" />
                                            <label class="full" for="star3" title="Meh - 3 stars"></label>

                                            <input type="radio" id="star2half" name="rating" value="2.5" />
                                            <label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>

                                            <input type="radio" id="star2" name="rating" value="2" />
                                            <label class="full" for="star2" title="Kinda bad - 2 stars"></label>

                                            <input type="radio" id="star1half" name="rating" value="1 and a half" />
                                            <label class="half" for="star1half" title="Meh - 1.5 stars"></label>

                                            <input type="radio" id="star1" name="rating" value="1" />
                                            <label class="full" for="star1" title="Sucks big time - 1 star"></label>

                                            <input type="radio" id="starhalf" name="rating" value="1.5" />
                                            <label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                        </div>

                                    </div>
                                    <input type="submit" name="Save" placeholder="Save" onclick="submitId()">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
    <script src="js/kidprofile.js"></script>
    <script>
        window.onload = function () {
            var patharr = location.pathname.split("/");
            var fileName = patharr[3];
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
