<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="personAttribute">
    <div class="form-div" align="center">
        <div class="field">
            <label>First Name:</label>
            <input type="text" name="firstName"/>
        </div>
        <div class="field">
            <label>Last Surname:</label>
            <input type="text" name="lastName"/>
        </div>
        <div class="field">
            <label>Phone:</label>
            <input type="text" name="telephone"/>
        </div>
        <div class="field">
            <label>Address:</label>
            <input type="text" name="address"/>
        </div>
        <div class="field">
            <label>Email:</label>
            <input type="text" name="email"/>
        </div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>
