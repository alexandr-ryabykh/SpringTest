<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="personAttribute">
    <div class="field">
        <label>Name:</label>
        <input type="text" name="firstName" value="${contact.name}"/>
    </div>
    <div class="field">
        <label>Surname:</label>
        <input type="text" name="lastName" value="${contact.surname}"/>
    </div>
    <div class="field">
        <label>Phone:</label>
        <input type="text" name="telephone" value="${contact.phoneNumber}"/>
    </div>
    <div class="field">
        <label>Address:</label>
        <input type="text" name="address" value="${contact.address}"/>
    </div>
    <div class="field">
        <label>E-mail:</label>
        <input type="text" name="email" value="${contact.email}"/>
    </div>
    <input type="submit"/>
</form:form>
<form:form method="POST" action="/contact/${contact.id}/remove">
    <input type="submit" value="Remove"/>
</form:form>
</body>
</html>
