
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet14 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      ServletContext sc = getServletContext();
      String s = (String)sc.getAttribute("count");
      pw.println("Hit Count "+s);
    }

}
