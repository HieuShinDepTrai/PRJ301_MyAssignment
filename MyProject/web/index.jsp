<%-- 
    Document   : index.jsp
    Created on : Jul 6, 2022, 10:47:20 PM
    Author     : Hiếu Shin FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css" />
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div id="ctl00_divUser" style="float: right; margin-right: 16px;">
                    <span id="ctl00_lblCampusName" class="label label-success">
                        ${account.name}</span>
                      |
                      <span id="ctl00_lblCampusName" class="label label-success">
                        logout</span>
                      |
                      <span id="ctl00_lblCampusName" class="label label-success">
                        CAMPUS: FPTU-Hòa Lạc</span>
                </div>    
            </div>
        </div>
        <div>
            <p style="text-align: center; font-size: 50px"> Welcome to Attendance System </p><p><br>
                <a href="http://localhost:9999/Assignment/Home">1. Home</a><br><br>
                <a href="http://localhost:9999/Assignment/Schedule">2. View Schedule</a><br><br>
                <a href="http://localhost:9999/Assignment/Schedule">3. Attendance Report</a>
        </p></div>

        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    </body>
</html>
