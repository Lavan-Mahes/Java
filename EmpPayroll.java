import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;
public class EmpPayroll extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
res.setContentType("text/html;charset=UTF-8");
PrintWriter out = res.getWriter();
String s1=req.getParameter("t1");
String s2=req.getParameter("t2");
String s3=req.getParameter("t3");
String s4=req.getParameter("t4");
int bpay=Integer.parseInt(s4);
double da = 0.5 * bpay;
double ta = 0.15 * bpay;
double hra = 0.25 * bpay;
double pf = 0.10 * bpay;
double lic = 0.07 * bpay;
double grosspay = bpay + da + hra + ta;
double dd = pf + lic;
double netpay = grosspay - dd;
String sql= "insert into Table1 " + "values ('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+da+"', '"+ta+"', '"+hra+"',
'"+pf+"', '"+lic+"', '"+grosspay+"', '"+dd+"', '"+netpay+"' )";
System.out.println(sql);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:EmployeePayroll";
Connection con= DriverManager.getConnection(url);
Statement st=con.createStatement();
st.executeUpdate(sql);
ResultSet rs;
rs=st.executeQuery("select * from Table1");
out.print("<H3> EMPLOYEE DETAILS </h3>");
out.print("<Body bgcolor=orange>");
out.print("<Table border=1><tr>");
out.print("<TD>EMPLOYEE ID</TD> <TD>EMPLOYEE NAME</TD> <TD>DESIGNATION</TD> <TD>BASIC
PAY</TD> <TD>DA</TD> <TD>TA</TD> <TD>HRA</TD> <TD>PF</TD> <TD>LIC</TD> <TD>GROSS PAY</TD>
<TD>DEDUCTIONS</TD> <TD>NET PAY</TD></tr>");
while(rs.next( ))
{
String str1=rs.getString(1);
String str2=rs.getString(2);
String str3=rs.getString(3);
String str4=rs.getString(4);
String str5=rs.getString(5);
String str6=rs.getString(6);
String str7=rs.getString(7);
String str8=rs.getString(8);
String str9=rs.getString(9);
String str10=rs.getString(10);
String str11=rs.getString(11);
String str12=rs.getString(12);
out.println("<tr><td>");
out.print(str1);
out.println("</td>");
out.println("<td>");
out.print(str2);
out.println("</td>");
out.println("<td>");
out.print(str3);
out.println("</td>");
out.println("<td>");
out.print(str4);
out.println("</td>");
out.println("<td>");
out.print(str5);
out.println("</td>");
out.println("<td>");
out.print(str6);
out.println("</td>");
out.println("<td>");
out.print(str7);
out.println("</td>");
out.println("<td>");
out.print(str8);
out.println("</td>");
out.println("<td>");
out.print(str9);
out.println("</td>");
out.println("<td>");
out.print(str10);
out.println("</td>");
out.println("<td>");
out.print(str11);
out.println("</td>");
out.println("<td>");
out.print(str12);
out.println("</td> </tr>");
}
out.print("</body>");
}
catch (Exception e)
{
System.out.println(e);
}
}
}
