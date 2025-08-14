package assignments.servlets;
//import javax.servlet.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
//import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String s = request.getParameter("name");
        String s1 = request.getParameter("age");
        pw.println("Your Name is "+s);
        pw.println("<br/>");
        pw.println("Your Age is "+s1);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String s = (String)en.nextElement();
            String s1 = request.getParameter(s);
            pw.println("Parameter Name= "+s);
            pw.println("Parameter Value= "+s1);
            pw.println("<br/>");
        }
    }

}
