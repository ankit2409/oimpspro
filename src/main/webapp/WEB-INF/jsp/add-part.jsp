<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Add Part</title>
    </head>
    <h1>Add Part</h1>
    <body>
        <c:if test="${addPartSuccess}">
            <div>Successfully added Part with Name: ${savedPart.name}</div>
        </c:if>


        <c:url var="add_part_url" value="/Part/addPart"/>
        <form:form action="${add_part_url}" method="post" modelAttribute="part">
            <form:label path="name">Part Name: </form:label> <form:input type="text" path="name"/>
            <label for="rawMaterialId">Raw Material:</label>
                      <select id="rawMaterialId" name="rawMaterialId">
                        <c:forEach var="rawMaterial" items="${rawMaterials}">
                          <option value="${rawMaterial.id}">${rawMaterial.name}</option>
                        </c:forEach>
                      </select>
            </br>
            </br>
            <form:label path="quantity">Part Quantity: </form:label> <form:input path="quantity"/>
            <form:label path="weight">Part Weight: </form:label> <form:input path="weight"/>
            <form:label path="drawingUrl">Upload Drawing: </form:label> <form:input path="drawingUrl"/>
            </br>
            </br>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>