<jsp:include page="../header.jsp"/>




<div align="center">
  <h1>Reimbursements</h1>
 </div>
 <hr>

<div class="displayBody">

<h3>Pending</h3>
<div> <%=request.getAttribute("pending")%> </div>


<h3>Approved</h3>
<div> <%=request.getAttribute("approved")%> </div>


<h3>Denied</h3>
<div> <%=request.getAttribute("denied")%> </div>



</div>

<jsp:include page="../footer.jsp"/>