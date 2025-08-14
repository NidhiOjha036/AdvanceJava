
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet11 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      String s = (String)request.getAttribute("name");
      pw.println("Hello "+s);
    }

}
