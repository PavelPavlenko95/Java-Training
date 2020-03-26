<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<p> ${typeOfParser}  </p>

<table class="item-table">
    <tr>
        <th>${id}</th>
        <th>${name}</th>
        <th>${type}</th>
        <th>${link}</th>
        <th>${length}</th>
        <th>${tests}</th>
        <th>${date}</th>
    </tr>

    <c:forEach items="${lecturesList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.lectureType}</td>
            <td>${item.link}</td>
            <td>${item.length}</td>
            <td>${item.tests}</td>
            <td>${item.date}</td>
        </tr>
    </c:forEach>

</table>
<body>
</body>
</html>
