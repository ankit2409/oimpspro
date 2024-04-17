<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Raw Material</title>
    </head>
    <h1>Add Raw Material</h1>
    <body>
        <c:if test="${addRawMaterialSuccess}">
            <div>Successfully added RawMaterial with Grade: ${savedRawMaterial.grade}</div>
        </c:if>

        <c:url var="add_rawMaterial_url" value="/rawMaterial/addRawMaterial"/>
        <form:form action="${add_rawMaterial_url}" method="post" modelAttribute="rawMaterial">
            <form:label path="name">Name: </form:label> <form:input type="text" path="name"/>
            <form:label path="grade">Grade: </form:label> <form:input type="text" path="grade"/>
            <form:label path="material">Material: </form:label> <form:input type="text" path="material"/>
            <form:label path="size">Size: </form:label> <form:input type="text" path="size"/>
            <form:label path="quantity">Quantity: </form:label> <form:input path="quantity"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>