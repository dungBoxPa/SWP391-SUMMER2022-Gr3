<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="/ATKD_Project/parent/css/parenthome.css">
        <link rel="stylesheet" href="/ATKD_Project/parent/css/kidprofile.css">
        <script src="https://kit.fontawesome.com/67b5c45612.js" crossorigin="anonymous"></script>
        <script src="js/childdetails.js"></script>
        <link rel="stylesheet" href="/ATKD_Project/parent/css/childdetails.css">
        <style>

        </style>
    </head>

    <body>
        <div class="wrapper">
            <div class="home">
                <div class="left-side-menu">
                    <div class="vertical-menu">
                        <div class="user-welcome">
                            <img class="user-img" src="/ATKD_Project/parent/img/userImg/dummy-user-img.png" style="width: 80px; height: 80px;" alt="">
                            <p>${sessionScope.account.first_name} ${sessionScope.account.last_name}</p>
                        </div>
                        <div class="menu-item-container">
                            <ul class="item-lists">
                                <li class="menu-item current1">
                                    <a href="/ATKD_Project/parent/childdetails.jsp">Child Information</a>
                                </li>
                                <li class="menu-item">
                                    <a href="">Parent Information</a>
                                </li>
                                <li class="menu-item">
                                    <a href="">Child Register</a>
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
                                    <img src="/ATKD_Project/parent/img/userImg/dummy-user-img.png" alt="">
                                </div>

                                <div class="personel-section">
                                    
                                <h2>                     ${mainchild.getFullName()}                             </h2>
                                <form action="childdetailservlet" method="GET">
                                <label for="mainchildid">Choose kinderdergartner</label>
                                <select name="mainchildid" id="mainchildid">
                                    <c:forEach items="${kidlist}" var="k">
                                            <option value="${k.getKinder_id()}">
                                                <h1>${k.getFullName()}</h1>
                                            </option>
                                    </c:forEach>
                                    </select>  
                                    <input type="submit" value="Change kindergartner">
                                </form>    
                                    <p>${mainchild.getDob()}</p>
                                </div>
                            </div>
                            <div class="list-option" id="options">
                                <div class="attendence option-item current">
                                    <a href="checkAttendence.jsp">Attendence</a>
                                </div>
                                <div class="feedback option-item">
                                    <a href="feedback.jsp">Feedback</a>
                                </div>
                                <div class="profile option-item">
                                    <a href="kidprofile.jsp">Profile</a>
                                </div>
                            </div>

                            <div class="attendence-section">
                                <table>
                                    <tr>
                                        <td class="present">1</td>
                                        <td class="present">2</td>
                                        <td class="present">3</td>
                                        <td class="present">4</td>
                                        <td class="present">5</td>
                                        <td class="present">6</td>
                                    </tr>
                                    <tr>
                                        <td class="present">7</td>
                                        <td class="present">8</td>
                                        <td class="absent">9</td>
                                        <td class="present">10</td>
                                        <td class="absent">11</td>
                                        <td class="present">12</td>
                                    </tr>
                                    <tr>
                                        <td>13</td>
                                        <td>14</td>
                                        <td>15</td>
                                        <td>16</td>
                                        <td>17</td>
                                        <td>18</td>
                                    </tr>
                                    <tr>
                                        <td>19</td>
                                        <td>20</td>
                                        <td>21</td>
                                        <td>22</td>
                                        <td>23</td>
                                        <td>24</td>
                                    </tr>
                                    <tr>
                                        <td class="present">25</td>
                                        <td>26</td>
                                        <td>27</td>
                                        <td>28</td>
                                        <td>29</td>
                                        <td>30</td>
                                    </tr>
                                    <tr>
                                        <td class="present">31</td>
                                    </tr>
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
        }
    </script>
    

</html>