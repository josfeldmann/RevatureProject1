<jsp:include page="../header.jsp"/>

<div align="center">
  <h1>Reimbursements</h1>
 </div>
 <hr>

<div class="displayBody">

<h3>Pending</h3>
<div>
<%=request.getAttribute("pending")%> </div>
</div>


<jsp:include page="../footer.jsp"/>