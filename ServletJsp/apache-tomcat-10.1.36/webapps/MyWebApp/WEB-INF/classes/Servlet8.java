
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Date;

public class Servlet8 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String action = request.getParameter("action");
        if(action != null && action.equals("invalidate"))
        {
           HttpSession hs = request.getSession();
           hs.invalidate();
           pw.println("<B> Your Session has been Invalidated");
           pw.println("<BR>");
           String s = "http://localhost:8080/MyWebApp/s8";
           pw.println("<a href=\""+s+"\">");
           pw.println("Start New session </a>");
        }else
        {
            HttpSession hs = request.getSession();
            if(hs.isNew())
             pw.println("<B> New Session");
            else
             pw.println("<B> Old Session");
            pw.println("<BR>");
            pw.println("<B>Session ID = "+hs.getId());
            pw.println("<BR>");
            pw.println("<B>Creation Time = "+new Date(hs.getCreationTime()));
            pw.println("<BR>");
            pw.println("<B>Last Accessed Time = "+new Date(hs.getLastAccessedTime()));
            pw.println("<BR>");
            pw.println("<B>Max Inactive Interval = "+hs.getMaxInactiveInterval());
            pw.println("<BR>");
            String s = "http://localhost:8080/MyWebApp/s8";
            String s1 = "http://localhost:8080/MyWebApp/s8?action=invalidate";
            pw.println("<a href=\""+s+"\">");
            pw.println("Reload </a>");
            pw.println("<BR>");
            pw.println("<a href=\""+s1+"\">");
            pw.println("Invalidate Session </a>");
            hs.setAttribute("cart",new Cart());
        }
        
    }

}
