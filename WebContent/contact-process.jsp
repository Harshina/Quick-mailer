<%@page import="quickmailer.dataAccessObjectClass.ContactDao"%>
<%@page import="quickmailer.entities.Contact"%>
<%
Contact contact=new Contact();
contact.setUname(request.getParameter("uname"));
contact.setDob(request.getParameter("dob"));
 contact.setEmail(request.getParameter("email"));
 contact.setMobile(Long.parseLong(request.getParameter("mobile")));
 new ContactDao().checkContact(contact);
 response.sendRedirect("contact.jsp");

%>