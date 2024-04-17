<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Machine</title>
    </head>
    <h1>Add Machine</h1>
    <body>
        <c:if test="${addMachineSuccess}">
            <div>Successfully added Machine with Name: ${savedMachine.name}</div>
        </c:if>

        <c:url var="add_machine_url" value="/machine/addMachine"/>
        <form:form action="${add_machine_url}" method="post" modelAttribute="machine">
            <form:label path="code">Code: </form:label> <form:input type="text" path="code"/>
            </br>
            </br>
            <form:label path="name">Machine Name: </form:label> <form:input type="text" path="name"/>
            </br>
            </br>
            <form:label path="type">Machine Type: </form:label> <form:input path="type"/>
            </br>
            </br>
            <form:label path="status">Machine Status: </form:label> <form:input path="status"/>
            </br>
            </br>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>