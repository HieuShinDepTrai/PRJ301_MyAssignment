<%-- 
    Document   : report.jsp
    Created on : Jul 7, 2022, 5:39:32 PM
    Author     : Hiếu Shin FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take attendance</title>
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css" />

    </head>
    <body>
        <div class="container mx-auto w-[1000px]">

            <form method="post">
                <h1> ROOM: ${session.room.roomName}</h1>
                <h1> CLASS: ${session.classes.className}</h1>
                <h1> COURSE: ${session.course.courseName}</h1>
                <div class="relative overflow-x-auto shadow-md sm:rounded-lg mt-5">
                    <table class="w-full text-sm text-left text-gray-500 ">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50 ">
                            <tr class="border-b">
                                <th scope="col" class="px-6 py-3">
                                    UserID
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Mail
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Check
                                </th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${session.attendance}" var="attend">
                                <tr class="bg-white border-b ">
                                    <th scope="row" class="px-6 py-4 font-medium text-gray-900">
                                        ${attend.users.userId}
                                    </th>
                                    <td class="px-6 py-4">
                                        ${attend.users.name}
                                    </td>
                                    <td class="px-6 py-4">
                                        ${attend.users.email}
                                    </td>
                                    <td class="px-6 py-4">
                                        <div class="flex items-center mb-4">
                                            <input type="hidden" name="user" value="${attend.users.userId}"/>
                                            <input type="hidden" name="status" id="status-${attend.users.userId}" value="${attend.status}"/>
                                            <input onchange="$('#status-${attend.users.userId}').val('true')" ${attend.status==true ? "checked" : ""}  type="radio" value="true" name="${attend.users.userId}_status" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 ">
                                            <label class="ml-2 text-sm font-medium text-gray-900 mr-10">Attended</label>
                                            <input onchange="$('#status-${attend.users.userId}').val('false')" ${attend.status==false ? "checked" : ""} type="radio" value="false" name="${attend.users.userId}_status" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 ">
                                            <label class="ml-2 text-sm font-medium text-gray-900 ">Absent</label>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="flex justify-center ">
                    <button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Save</button>
                </div>

            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    </body>
</html>
