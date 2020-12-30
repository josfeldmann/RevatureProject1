 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>

<c:if test="${account_type eq 1}">
<c:redirect url = "/Employee/EmployeeHomePage.jsp"/>
</c:if>
<c:if test="${account_type eq 2}">
<c:redirect url = "/Admin/AdminHomePage.jsp"/>
</c:if>

<div class="displayBody" style = "text-align:center">
<h1>Welcome to the Generic Bank Site!</h1>
<form action="login.jsp">
<button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
<jsp:include page="footer.jsp"/>





