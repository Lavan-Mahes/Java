<%@ page import="java.io.*,java.sql.*,java.lang.*" %>
<%!
String name = "test";
String pass = "test";
String url = "jdbc:odbc:order";
Connection con=null;
Statement st=null;
String t1=" ";
String t2=" ";
String t3=" ";
String t4=" ";
String t5=" ";
String t6=" ";
String t7=" ";
String t8=" ";
String t9=" ";
int no;
%>
<%
try
{
t1=request.getParameter("name");
t2=request.getParameter("address");
t3=request.getParameter("email");
t4=request.getParameter("mobile");
t5=request.getParameter("title");
t6=request.getParameter("author");
t7=request.getParameter("publisher");
t8=request.getParameter("edition");
t9=request.getParameter("quantity");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con = DriverManager.getConnection(url, name, pass);
st=con.createStatement();
no=st.executeUpdate("insert into jsp_book
values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"','"+t8+"','"+t9+"')");
con.close();
out.println("<h1> <br><br><br><br><center>THANKS FOR YOUR ORDER</center>");
out.println("<h1>Mr/Ms. "+t1+"<h3> your request for the following book(s) Will dispatch as soon as poosible ");
out.println("<center><table> <tr> <td><h4> Book Title :</h4></td><td> "+t5+" </td></tr>");
out.println("<tr> <td><h4> Author :</h4></td><td>" +t6+ "</td></tr>" );
out.println("<tr> <td><h4> Publisher :</h4></td><td>" +t7+ "</td></tr></table></center>");
}
catch(SQLException e)
{
out.println("Error"+e);
}
%>
