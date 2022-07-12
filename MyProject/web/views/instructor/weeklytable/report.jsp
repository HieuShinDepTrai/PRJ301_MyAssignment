<%-- 
    Document   : report.jsp
    Created on : Jul 7, 2022, 5:39:32 PM
    Author     : Hiếu Shin FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css" />

    </head>
    <body>
        <div class="container mx-auto bg-gray-300 w-[1000px]">
            <h1>Weekly Attendace</h1>
            <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
                <table class="w-full text-sm text-left text-gray-500 ">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50 ">
                        <tr class="border-b">
                            <th scope="col" class="px-20 py-3">
                                YEAR
                            </th>
                            <th scope="col" class="px-6 py-3">
                                MON
                            </th>
                            <th scope="col" class="px-6 py-3">
                                TUE
                            </th>
                            <th scope="col" class="px-6 py-3">
                                WED
                            </th>
                            <th scope="col" class="px-6 py-3">
                                THU
                            </th>
                            <th scope="col" class="px-6 py-3">
                                FRI
                            </th>
                            <th scope="col" class="px-6 py-3">
                                SAT
                            </th>
                            <th scope="col" class="px-6 py-3">
                                SUN
                            </th>

                        </tr>
                        <tr class="border-b">
                            <th scope="col" class="px-20 py-3">
                                WEEK
                            </th>
                            <th scope="col" class="px-6 py-3">
                                04/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                05/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                06/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                07/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                08/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                09/07
                            </th>
                            <th scope="col" class="px-6 py-3">
                                10/07
                            </th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr class="bg-white border-b ">
                            <th scope="row" class="px-20 py-4 font-medium text-gray-900">
                                Slot 1
                            </th>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                        </tr>
                        <tr class="bg-white border-b ">
                            <th scope="row" class="px-20 py-4 font-medium text-gray-900">
                                Slot 2
                            </th>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                            <td class="px-6 py-4">
                                -
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    </body>
</html>
