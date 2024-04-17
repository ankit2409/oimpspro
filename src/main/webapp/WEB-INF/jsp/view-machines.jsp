<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Machines</title>
        <link href="<c:url value='/css/common.css' />" rel="stylesheet" type="text/css">

    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${machines}" var="machine">
                    <tr>
                        <td>${machine.code}</td>
                        <td>${machine.name}</td>
                        <td>${machine.type}</td>
                        <td>${machine.status}</td>
                    </tr>
                    <br>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>