<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="error" class="utility.ErrorBean" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="../headerHtml.jsp"></jsp:include>

   <body>
      <div id="ch-container">
         <div class="row">
            <div class="col-md-12 center login-header">
               <h2>Benvenuto nel Programma Gestionale Alfasoft</h2>
            </div>
         </div>
         
         <div class="row">
         <%=error.getError()%>
         <div class="well col-md-5 center login-box">
             <div class="alert alert-info">
                 Effettuare il Login inserendo Username e Password
             </div>
         
             <form class="form-horizontal" action="doLogin.jsp" method="post">
               <fieldset>
      
                 <div class="input-group input-group-lg">
                     <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                     <input type="text" class="form-control" name="username" placeholder="Username">
                 </div>
                 <div class="clearfix"></div><br>
         
                 <div class="input-group input-group-lg">
                     <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                     <input type="password" class="form-control" name="password" placeholder="Password">
                 </div>
                 <div class="clearfix"></div>
         
                 <div class="input-prepend">
                     <label class="remember" for="remember"><input type="checkbox" id="remember"> Remember me</label>
                 </div>
                 <div class="clearfix"></div>
         
                 <input type= "hidden" name="call" value="2"/><br>
      
                 <p class="center col-md-5">
                     <button type="submit" class="btn btn-primary">Login</button>
                 </p>
               </fieldset>

             </form>
         </div>
        </div>
        
      <jsp:include page="../footer.jsp"></jsp:include>
      
   </div>
   
<jsp:include page="../IncludeScriptEnd.jsp"></jsp:include>

</body>

</html>