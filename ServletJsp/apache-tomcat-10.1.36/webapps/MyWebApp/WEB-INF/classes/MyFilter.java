
package assignments.servlets;
import jakarta.servlet.*;
import java.io.*;

public class MyFilter implements Filter{

    FilterConfig fc;
    public void init(FilterConfig fc) throws ServletException
    {
        this.fc = fc;
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        ServletContext sc = fc.getServletContext();
        String s = (String)sc.getAttribute("count");
        if(s == null){
            sc.setAttribute("count","1");
        }else{
            int i = Integer.parseInt(s);
            i++;
            sc.setAttribute("count",String.valueOf(i));
        }
        pw.println("Before");
        chain.doFilter(request,response);
        pw.println("After");
    }
    public void destroy(){

    }
}
