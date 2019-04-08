import java.sql.*;
import java.io.*;
public class StudentInfo
{
public static void main(String args[])
{
String url = "jdbc:odbc:StudentsDetails";
Connection con;
String createTable1;
String createTable2;
createTable1 = "create table PersonalInfo " + "(NAME varchar(32), " + "ROLLNO int, " + "AGE int, " +
"EMAIL varchar(32), " + "ADDRESS varchar(32), " + "PHONENO long, " + "BLOODROUP varchar(20))";
createTable2 = "create table AcademicInfo " + "(ROLLNO int, " + "SEMESTER1 int, " + "SEMESTER2 int, " +
"SEMESTER3 int, " + "SEMESTER4 int, " + "SEMESTER5 int, " + "SEMESTER6 int, " + "RESULT
varchar(32))";
Statement stmt;
DataInputStream dis=new DataInputStream (System.in);
String query = "select PersonalInfo.NAME, AcademicInfo.RESULT from PersonalInfo,AcademicInfo where
PersonalInfo.ROLLNO=AcademicInfo.ROLLNO";
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
con = DriverManager.getConnection(url);
stmt = con.createStatement();
stmt.executeUpdate(createTable1);
stmt.executeUpdate(createTable2);
System.out.print ("\n\t Enter the Number of Records: ");
int norec=Integer.parseInt(dis.readLine());
for (int i=1;i<=norec;i++)
{
System.out.print ("\n\t Enter the Name: ");
String name=dis.readLine();
System.out.print ("\n\t Enter the Roll Number: ");
int rollno=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Age: ");
int age=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Email Id: ");
String email=dis.readLine();
System.out.print ("\n\t Enter the Address: ");
String addr=dis.readLine();
System.out.print ("\n\t Enter the Phone Number: ");
int phno=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Blood Group: ");
String bgrp=dis.readLine();
stmt.executeUpdate("insert into PersonalInfo " + "values(' "+name+" ', "+rollno+",
"+age+", ' "+email+" ', ' "+addr+" ', "+phno+", ' "+bgrp+" ')");
System.out.print ("\n\t Enter the Semester1 Marks: ");
int s1=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Semester2 Marks: ");
int s2=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Semester3 Marks: ");
int s3=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Semester4 Marks: ");
int s4=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Semester5 Marks: ");
int s5=Integer.parseInt(dis.readLine());
System.out.print ("\n\t Enter the Semester6 Marks: ");
int s6=Integer.parseInt(dis.readLine());
int tot=s1+s2+s3+s4+s5+s6;
float avg=tot/6;
String c=new String();
if (avg>=50) c = "PASS";
else c="FAIL";
stmt.executeUpdate("insert into AcademicInfo " + "values("+rollno+", "+s1+", "+s2+",
"+s3+", "+s4+", "+s5+", "+s6+", ' "+c+" ' )");
}
ResultSet rs = stmt.executeQuery(query);
System.out.println("\n\n\t\tResult of Students:");
while (rs.next())
{
String nam = rs.getString("NAME");
String res = rs.getString("RESULT");
System.out.println("\n\t\t\t " + nam + " " + res);
}
stmt.close();
con.close();
}
catch(Exception ex)
{
System.err.println("SQLException: " + " here" + ex.getMessage());
}
System.out.println("\n\t\t Table Created");
}
}
