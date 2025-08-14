
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Servlet6 extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Cookie[] c = request.getCookies();
        if( c!= null)
        {
            for(Cookie cu : c)
            {
                String s = cu.getName();
                if(s.equals("MyCookie"))
                {
                    String s1 = cu.getValue();
                    pw.println("Hi "+s1);
                }
            }
        }
        else
        {
            pw.println("No Cookies Found");
        }
    }

}
