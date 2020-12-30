<jsp:include page="../header.jsp"/>
 <div align="center">
  <h1>Employee Homepage</h1>
 </div>
 <hr>

<div class="displayBody" style = "text-align:center">
    <form action="<%=request.getContextPath()%>/Employee/SubmitReimbursementRequest.jsp">
        <button class="btn btn-primary displayButton">Submit Reimbursement Request</button><br><br>
    </form>
    <form action="<%=request.getContextPath()%>/viewEmployeeReimbursementRequests">
        <button class="btn btn-primary displayButton">View Reimbursement Requests</button><br><br>
    </form>
    <form action="<%=request.getContextPath()%>/viewEmployeeInformation" method="post">
        <button class="btn btn-primary displayButton">View/Update Account Information</button><br><br>
    </form>
</div>
<jsp:include page="../footer.jsp"/>