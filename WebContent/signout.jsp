<%
if(session.getAttribute("user_name")!=null){
	session.invalidate();
	response.sendRedirect("homepage.jsp");
}


%>