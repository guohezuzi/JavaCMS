<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guohezuzi
  Date: 18-2-15
  Time: 下午1:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/default.css"/>">
</head>
<body>
    <div id="header">
        <t:insertAttribute name="header"/>
    </div>
    <div id="content">
        <t:insertAttribute name="body"/>
    </div>
    <div id="footer">
        <t:insertAttribute name="footer"/>
    </div>
</body>
</html>
