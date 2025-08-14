
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet12 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      ServletContext sc = getServletContext();
      sc.setAttribute("name","Mikado");
      pw.println("Attribute set in Servlet");
    }

}
