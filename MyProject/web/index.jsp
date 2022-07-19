<%-- 
    Document   : index.jsp
    Created on : Jul 6, 2022, 10:47:20 PM
    Author     : Hiếu Shin FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css" />
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div>
            <p style="font-size: 70px;
               font-weight: 600;
               background-image: linear-gradient(45deg, #553c9a, #ee4b2b);
               color: transparent;
               background-clip: text;
               -webkit-background-clip: text;
               text-align: center;
               "> Welcome to Attendance System </p><p><br>
            </p></div>
        <div style="margin-bottom: 100px;" class="container">
            <div class="row">
                <div id="ctl00_divUser" style="float: right; margin-right: 50px;">
                    <c:if test="${account!=null}">
                        <a style="background-image: linear-gradient(to right, #fdcbf1 45%, #e6dee9);
                           padding: 5px;
                           border-radius: 5px;" id="ctl00_lblCampusName" class="label label-success">
                            ${account.name}</a>
                        |
                    </c:if>
                    <c:if test="${account == null}">
                        <a style="background-image: linear-gradient(to right, #fdcbf1 45%, #e6dee9);
                           padding: 5px;
                           border-radius: 5px;" href="${pageContext.request.contextPath}/login" id="ctl00_lblCampusName" class="label label-success">
                            Login</a>
                        |
                    </c:if>
                    <a style="background-image: linear-gradient(to right, #fdcbf1 45%, #e6dee9);
                       padding: 5px;
                       border-radius: 5px;" href="${pageContext.request.contextPath}/logout" id="ctl00_lblCampusName" class="label label-success">
                        Logout</a>
                    |
                    <a style="background-image: linear-gradient(to right, #fdcbf1 45%, #e6dee9);
                       padding: 5px;
                       border-radius: 5px;" id="ctl00_lblCampusName" class="label label-success">
                        CAMPUS: FPTU-Hòa Lạc</a>
                </div>    
            </div>
        </div>
        <a style="background-image: linear-gradient(to right, #108dc7 45%, #ef8e38);
           padding: 5px;
           border-radius: 5px;
           font-size: 50px;
           color: transparent;
           background-clip: text;
           -webkit-background-clip: text;
           margin-left: 40%;
           margin-right: 40%;
           " href="http://localhost:8080/MyProject">1. Home</a><br><br>
        <a style="background-image: linear-gradient(to right, #108dc7 45%, #ef8e38);
           padding: 5px;
           border-radius: 5px;
           font-size: 50px;
           color: transparent;
           background-clip: text;
           -webkit-background-clip: text;
           margin-left: 35%;
           margin-right: 35%;"
           href="http://localhost:8080/MyProject/session">2. View Schedule</a><br><br>
<!--        <a style="background-image: linear-gradient(to right, #108dc7 45%, #ef8e38);
           padding: 5px;
           border-radius: 5px;
           font-size: 50px;
           color: transparent;
           background-clip: text;
           -webkit-background-clip: text;
           margin-left: 32%;
           margin-right: 32%;" 
           href="http://localhost:8080/MyProject/report/attendance">3. Attendance Report</a>-->
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    </body>
</html>
