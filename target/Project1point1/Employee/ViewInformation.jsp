<jsp:include page="../header.jsp"/>





    <form action="<%=request.getContextPath()%>/updateInformation" method="post" class="displayBody">
    <h1>Update Employee Information</h1>
       <div class="form-group">
           <label for="username">User Name:</label> <input type="text"
            class="form-control" id="username" placeholder="User Name"
            name="username" value='<%=request.getAttribute("username")%>' required>
          </div>
          <div class="form-group">
                     <label for="password">Password:</label> <input type="text"
                      class="form-control" id="password" placeholder="Enter new password here. Leave blank if you don't want to change it."
                      name="password" value = ""  required>
           </div>
           <div class="form-group">
               <label for="first_name">First Name:</label> <input type = "text"
                class="form-control" id="first_name" placeholder="First Name"
                name="first_name" value='<%=request.getAttribute("first_name")%>' required>
           </div>

           <div class="form-group">
                       <label for="last_name">Last Name:</label> <input type = "text"
                        class="form-control" id="last_name" placeholder="Last Name"
                        name="last_name" value='<%=request.getAttribute("last_name")%>' required>
           </div>

           <button type="submit" class="btn btn-primary">Update</button><br><br>
       </form>


<jsp:include page="../footer.jsp"/>