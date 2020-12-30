<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
  <link rel="stylesheet"
 href="${pageContext.request.contextPath}/style.css">
</head>
<body>


<c:choose>
    <c:when test="${empty username}">
        <%@ include file="loginbar.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="logoutbar.jsp" %>
    </c:otherwise>
</c:choose>

<c:choose>
<c:when test="${not empty result}">
<div class = "displayBody"><div class = "bg-success" style="text-align: center"><%= session.getAttribute("result") %></div></div>
<c:remove var="result"/>
</c:when>
</c:choose>


<c:choose>
<c:when test="${not empty error}">
<div class = "displayBody"><div class = "bg-danger" style="text-align: center"><%= session.getAttribute("error") %></div></div>
<c:remove var="error"/>
</c:when>
</c:choose>






