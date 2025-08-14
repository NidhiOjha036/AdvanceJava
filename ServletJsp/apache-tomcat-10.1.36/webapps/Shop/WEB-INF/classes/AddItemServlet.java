package cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AddItemServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        ItemDAO dao = new ItemDAO();
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        try 
        {
            int itemCount = dao.getItemCount();
            for(int i = 1; i <= itemCount; i++)
            {
                String s = request.getParameter("item"+i);
                if(s != null)
                {
                    Item item = dao.getItem(i);
                    CartItem cartItem = new CartItem("cartItem"+item.getId(), item, 1);
                    cart.addCartItem(cartItem);
                }
            }
            response.sendRedirect("/Shop/DisplayCart.jsp");
            //request.getRequestDispatcher("/DisplayCart.jsp").forward(request,response);

            
        } catch (Exception e) {
            pw.println(e);
        }
    }
}
