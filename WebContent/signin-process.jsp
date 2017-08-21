<%@page import="quickmailer.dataAccessObjectClass.ContactDao"%>
<%@page import="quickmailer.entities.Login"%>
<%

Login login=new Login();
login.setUname(request.getParameter("uname"));
login.setPassword(request.getParameter("password"));

String userType=new ContactDao().loginValidate(login);

if(userType.equals("VALID")){
	session.setAttribute("user_name", login.getUname());
	response.sendRedirect("contact.jsp");
}else{
	out.println("INVALID USER TRY AGAIN WITH VALID UNAME AND PASSWORD");
	response.setHeader("refresh", "2;URL=signin.jsp");
	
}
%>