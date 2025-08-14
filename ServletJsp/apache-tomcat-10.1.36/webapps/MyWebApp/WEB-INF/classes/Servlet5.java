
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet5 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String s = request.getParameter("name");
        Cookie c = new Cookie("MyCookie",s);
        c.setMaxAge(10000); //stored cookies
        response.addCookie(c);
        pw.println("Cookie sent to your m/c");
    }

}
