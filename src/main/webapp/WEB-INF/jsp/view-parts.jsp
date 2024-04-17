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
                    <th>materialId</th>
                    <th>Weight</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${parts}" var="part">
                    <tr>
                        <td>${part.name}</td>
                        <td>${part.materialId}</td>
                        <td>${part.status}</td>
                    </tr>
                    <br>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>