
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet9 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession hs = request.getSession(false);//if no existing session of servlet8 then will not create new, returns null.
        if(hs == null)
        {
            pw.println("Session Expired");
        }
        else
        {
            Cart c = (Cart)hs.getAttribute("cart");
            if(c == null)
             pw.println("No Cart Available For You");
            else
             pw.println(c);
        }
    }

}
