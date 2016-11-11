<%@page import="modelBean.Admin"%>
<%@page import="modelBean.Cliente"%>
<%@page import="modelBean.Dipendente"%>
<%@page import="modelBean.Utente"%>
<%@page import="utility.ErrorBean"%>
<%@page import="service.Gestione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="modelBean.Utente" scope="session"></jsp:useBean>
<jsp:useBean id="admin" class="modelBean.Admin" scope="session"></jsp:useBean>
<jsp:useBean id="cliente" class="modelBean.Cliente" scope="session"></jsp:useBean>
<jsp:useBean id="dipendente" class="modelBean.Dipendente" scope="session"></jsp:useBean>
<jsp:useBean id="error" class="utility.ErrorBean" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="utente" />
    <%
	   
        Gestione g= new Gestione();
    
        if(request.getParameter("call")==null){
    	
    	%>
    	<jsp:forward page="Login.jsp"></jsp:forward>
    	<%
    	
        } else{
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");
        	
        	Utente u  = g.getUtenteConUsername(username);
        	
        	
        	if(u==null){
        		error.setError("Errore! Username o Password non corretti!");
        		
        		%>
            	     <jsp:forward page="Login.jsp"></jsp:forward>
            	<%
            	
        	} else{
        		
        	 utente.setNome(u.getNome());
         	 utente.setCognome(u.getCognome());
         	 utente.setRuolo(u.getRuolo());
         	 char ruolo = u.getRuolo();
         	     switch(ruolo){
         	     case 'D':
         	    	Dipendente d = g.getDipendenteConUsername(username);
        			session.setAttribute("dipendente", d);
         	    	 %>
              	    <jsp:forward page="../Dipendente/HomePageDipendente.jsp" />
              	    <%
         	    	break;
              	    
         	     case 'C':
         	    	Cliente c = g.getClienteConUsername(username);
        			session.setAttribute("cliente", c);
         	    	 %>
              	    <jsp:forward page="../Cliente/HomePageCliente.jsp" />
              	    <%
              	    break;
              	    
         	     case 'A':
         	    	Admin a = g.getAdminConUsername(username);
        			session.setAttribute("admin", a);
         	    	 %>
              	    <jsp:forward page="../Admin/HomePageAdmin.jsp" />
              	    <%
              	    break;
         	    	 
         	     }
         }
     }
    
    %>