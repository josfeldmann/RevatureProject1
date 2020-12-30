<jsp:include page="../header.jsp"/>
 <div align="center">
  <h1>Admin Homepage</h1>
 </div>
 <hr>

<div class="displayBody" style = "text-align:center">
    <form action="<%=request.getContextPath()%>/Admin/RegisterEmployee.jsp">
        <button class="btn btn-primary displayButton" type="submit">Register New Employee</button><br><br>
    </form>
    <form action="<%=request.getContextPath()%>/viewEmployees">
        <button class="btn btn-primary displayButton" type="submit">View Employees</button><br><br>
    </form>
    <form action="<%=request.getContextPath()%>/viewPendingReimbursements">
            <button class="btn btn-primary displayButton" type="submit">Approve/Deny Pending Reimbursements</button><br><br>
    </form>

</div>
<jsp:include page="../footer.jsp"/>