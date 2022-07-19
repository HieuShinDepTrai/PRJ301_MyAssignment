<%-- 
    Document   : report.jsp
    Created on : Jul 7, 2022, 5:39:32 PM
    Author     : Hiếu Shin FPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session</title>
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css" />
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.3.0/mdb.min.css"
            rel="stylesheet"
            />
    </head>
    <body>

        <div class="container pt-5">
            <form method="get" onchange="this.submit()">
                <select name="date" id="date-choices" class="form-select">

                </select>
            </form>

            <script>
                window.addEventListener('load', () => {
                    const startDate = new Date('2021-04-25').getTime();
                    const addWeek = (week) => {
                        const date = new Date(startDate + 1000 * 60 * 60 * 24 * 7 * week);
                        document.getElementById('date-choices').innerHTML += '<option value="' + date.getTime() + '">' + date.toDateString() + '</option>';
                    }

                    for (var i = 0; i < 100; i++) {
                        addWeek(i);
                    }
                });
            </script>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Slot</th>
                        <th scope="col">Sun</th>
                        <th scope="col">Mon</th>
                        <th scope="col">Tue</th>
                        <th scope="col">Wed</th>
                        <th scope="col">Thus</th>
                        <th scope="col">Fri</th>
                        <th scope="col">Sat</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="slot" begin="0" end="7">
                        <tr>
                            <th scope="row">${slot + 1}</th>
                                <c:forEach var="day" begin="0" end="6">
                                <td scope="row">
                                    <div><a href="report/attendance?sid=${data.get(slot).get(day).sessionId}&cid=${data.get(slot).get(day).classes.classId}">${data.get(slot).get(day).course.courseName}</a></div>
                                    <small>${data.get(slot).get(day).room.roomName}</small><br/>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
        </div>

        <!-- MDB -->
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.3.0/mdb.min.js"
        ></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    </body>
</html>
