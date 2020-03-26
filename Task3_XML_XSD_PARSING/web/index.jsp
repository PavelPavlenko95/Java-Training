<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%--<fmt:setLocale value="by_BY" scope="session" />--%>
<%--<fmt:setBundle basename="text" var="rb" />--%>
<html>
  <head>
<%--    <title><fmt:message key="text" bundle="${ rb }" /></title>--%>
  </head>
  <body>


  <form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />

    <select name="language">
      <option value="russian">russian</option>
      <option value="english" selected>english</option>
    </select>

    <select name="typeOfParser">
      <option value="SAX">SAX</option>
      <option value="DOM" selected>DOM</option>
      <option value="STAX">STAX</option>
    </select>

    <input type="submit" value="parse">
  </form>

  <ctg:hello role="${ user }"/>
  <ctg:info-time/>
<%--  <ctg:table-revenue rows="${ rw.size }" head="Revenue">--%>
<%--    ${ rw.revenue }--%>
<%--  </ctg:table-revenue >--%>
<%--  <ctg:table-revenue>5 rub BulbaComp</ctg:table-revenue >--%>

  </body>
</html>
