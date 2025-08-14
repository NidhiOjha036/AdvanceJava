<%@ page import="java.sql.*" %>
<%! Connection con; //Declarative tag
 public void jspInit()
 {
     try
     {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexamples","root","root");
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
 }
 public void jspDestroy()
 {
    try
    {
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
 }
%>
<% //scriptlet tag
    String s = request.getParameter("id");
    String s1 = request.getParameter("name");
    String s2 = request.getParameter("salary");
    try
    {
        PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
        pstmt.setInt(1,Integer.parseInt(s));
        pstmt.setString(2,s1);
        pstmt.setDouble(3,Double.parseDouble(s2));
        int i = pstmt.executeUpdate();
        out.println("No. of rows affected = "+i);
        pstmt.close();
    }
    catch(Exception e)
    {
        out.println(e);
    }
%>