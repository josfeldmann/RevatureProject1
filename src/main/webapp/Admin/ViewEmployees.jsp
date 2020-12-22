<jsp:include page="../header.jsp"/>
 <div align="center">
  <h1>Employees</h1>
 </div>
 <hr>

<div class="displayBody">

<div> <%=request.getAttribute("employees")%> </div>

</div>

<jsp:include page="../footer.jsp"/>