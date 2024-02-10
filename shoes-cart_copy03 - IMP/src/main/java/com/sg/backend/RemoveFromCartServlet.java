package com.sg.backend;
import com.sg.dao.CartDAO;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("cart_id"));


        int cartID = Integer.parseInt(request.getParameter("cart_id"));

        CartDAO.removeFromCart(cartID);

        response.sendRedirect("cart.jsp");
    }
}