
package assignments.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Date;

public class Servlet7 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession hs = request.getSession();
        String s = (String)hs.getAttribute("count");
        if(s == null)
        {
            pw.println("This is your 1st Visit");
            hs.setAttribute("count","1");
            hs.setAttribute("date",new Date());
        }else
        {
            int i = Integer.parseInt(s);
            i++;
            pw.println("This is your visit no. "+i);
            Date d = (Date)hs.getAttribute("date");
            pw.println("You last visited on "+d);
            hs.setAttribute("count",String.valueOf(i));
            hs.setAttribute("date",new Date());

        }
        
    }

}
