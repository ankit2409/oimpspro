<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Parts</title>
        <link href="<c:url value='/css/common.css' />" rel="stylesheet" type="text/css">

    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Code</th>
                    <th>Machine</th>
                    <th>status</th>
                    <th>count</th>
                    <th>Received Time</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${nodemcu}" var="nodemcu">
                    <tr>
                        <td>${nodemcu.name}</td>
                        <td>${nodemcu.code}</td>
                        <td>${nodemcu.machine}</td>
                        <td>${nodemcu.status}</td>
                        <td>${nodemcu.count}</td>
                        <td>${nodemcu.receivedTime}</td>
                    </tr>
                    <br>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>