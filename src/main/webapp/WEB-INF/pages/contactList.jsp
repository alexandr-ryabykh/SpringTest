<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/contact/add">Add new contact</a>
<a href="/">Welcome</a>
<ul>
    <c:forEach var="contact" items="${contactList}">
        <a href="${contact.id}">
                ${contact.firstName}
                ${contact.lastName}
        </a>
        <p>Phone #: ${contact.telephone}</p>
        <p>Address: ${contact.address}</p>
        <p>Email: ${contact.email}</p>
        <p>====================================</p>
    </c:forEach>
</ul>
</body>
</html>