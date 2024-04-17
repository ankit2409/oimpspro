<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Books</title>
        <link href="<c:url value='/css/common.css' />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Grade</th>
                    <th>Material</th>
                    <th>Size</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${rawMaterials}" var="rawMaterial">
                    <tr>
                        <td>${rawMaterial.name}</td>
                        <td>${rawMaterial.grade}</td>
                        <td>${rawMaterial.material}</td>
                        <td>${rawMaterial.size}</td>
                        <td>${rawMaterial.quantity}</td>
                    </tr>
                    <br>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>