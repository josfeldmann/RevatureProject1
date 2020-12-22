<jsp:include page="../header.jsp"/>
 <div align="center">
  <h1>Submit Reimbursement Request</h1>
 </div>
 <hr>

    <form action="<%=request.getContextPath()%>/submitReimbursement" method="post" class="displayBody">
        <div class="form-group">
            <label for="amount">Amount:</label> <input type = "number" min="0" max="100000"
             class="form-control" id="amount" placeholder="0.00"
             name="amount" required>
        </div>

        <div class="form-group">
                    <label for="purpose">Purpose:</label> <input type = "text"
                     class="form-control" id="purpose" placeholder="Briefly describe what the reimbursement is for"
                     name="purpose" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button><br><br>
    </form>

<jsp:include page="../footer.jsp"/>