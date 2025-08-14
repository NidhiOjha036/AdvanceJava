package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Servlet4 extends HttpServlet {

    Connection con;

    public void init()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexamples", "root", "root");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String s = request.getParameter("id");
        String s1 = request.getParameter("name");
        String s2 = request.getParameter("salary");

        try {

            PreparedStatement pstmt = con.prepareStatement("Insert into employee values(?,?,?)");
            pstmt.setInt(1, Integer.parseInt(s));
            pstmt.setString(2, s1);
            pstmt.setDouble(3, Double.parseDouble(s2));

            int i = pstmt.executeUpdate();
            pw.println("No of Rows affected = "+i);
            pstmt.close();
            
        } catch (Exception e) {
            pw.println(e);
        }
    }

    public void destroy(){
        try {
            con.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
   
}