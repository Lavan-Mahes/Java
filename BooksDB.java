import java.sql.*;
import java.io.*;
public class BooksDb
{
public static void main(String args[])
{
String url = "jdbc:odbc:Books";
String colname[] = new String[30];
Connection con;
String username="anonymous";
String password="guest";
Statement stmt;
int i=0;
DataInputStream dis=new DataInputStream (System.in);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
}
catch(java.lang.ClassNotFoundException e)
{
System.err.print("ClassNotFoundException: ");
System.err.println(e.getMessage());
}
try
{
con = DriverManager.getConnection(url,username,password);
stmt = con.createStatement();
ResultSet rs;
String query = "select * from Table1";
rs=stmt.executeQuery(query);
boolean moreRecords=rs.next();
if(!moreRecords)
{
System.out.println("\n\t\t No records to display");
}
else
{
ResultSetMetaData rsmd=rs.getMetaData();
int col=rsmd.getColumnCount();
System.out.println("\n\t\t Number of Columns in the table are: " + col);
for(i=1;i<=col;i++)
{
colname[i] = rsmd.getColumnName(i);
System.out.println("\n\t\t\t Column Name "+ i + " is :" + colname[i]);
}
while(rs.next())
{
for(i=1;i<=col;i++)
{
String a = rs.getString(colname[i++]);
System.out.println("\n\t\t\t Column Value for "+ i + " is :" + a);
}
}
}
stmt.close();
con.close();
}
catch(Exception ex)
{
System.err.println("SQLException: " + " here" + ex.getMessage());
}
}
}
