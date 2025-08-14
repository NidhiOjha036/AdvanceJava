package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet3 extends HttpServlet {

    String clientCompanyName;

    public void init()
    {
        ServletConfig sc = getServletConfig();
        clientCompanyName = sc.getInitParameter("name");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("Welcome to "+clientCompanyName);
    }
   
}