<jsp:include page="../header.jsp"/>
 <div align="center">
  <h1>Register New Employee</h1>
 </div>
 <hr>

    <form action="<%=request.getContextPath()%>/registerEmployee" method="post" class="displayBody">
    <div class="form-group">
        <label for="username">User Name:</label> <input type="text"
         class="form-control" id="username" placeholder="User Name"
         name="username" required>
       </div>
       <div class="form-group">
        <label for="password">Password:</label> <input type="password"
         class="form-control" id="password" placeholder="Password"
         name="password" required>
       </div>
        <div class="form-group">
            <label for="firstName">First Name:</label> <input type = "text"
             class="form-control" id="firstName" placeholder="First Name"
             name="firstName" required>
        </div>

        <div class="form-group">
                    <label for="lastName">Last Name:</label> <input type = "text"
                     class="form-control" id="lastName" placeholder="Last Name"
                     name="lastName" required>
        </div>

        <button type="submit" class="btn btn-primary">Register</button><br><br>
    </form>
<jsp:include page="../footer.jsp"/>