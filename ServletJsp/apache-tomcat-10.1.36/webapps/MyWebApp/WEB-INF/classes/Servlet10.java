
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet10 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      request.setAttribute("name","Mikado");
      //response.sendRedirect("http://localhost:8080/MyWebApp/s11");
      //response.sendRedirect("https://www.timesofindia.com");
      pw.println("Before");
    //   RequestDispatcher rd = request.getRequestDispatcher("/s11");
    //   rd.forward(request,response);
      request.getRequestDispatcher("/s11").include(request,response);
      pw.println("After");
    }

}
