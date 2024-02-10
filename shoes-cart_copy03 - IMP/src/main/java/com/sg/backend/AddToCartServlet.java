package com.sg.backend;
import com.sg.dao.CartDAO; // Import the CartDAO class

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        int price = Integer.parseInt(request.getParameter("price"));
        int totalQuantity = Integer.parseInt(request.getParameter("total_quantity"));
        int totalPrice = Integer.parseInt(request.getParameter("total_price"));
        
        
     // Get the user_id from the session
        int userId = (int) request.getSession().getAttribute("loggeduserId");

        boolean addedToCart = CartDAO.addToCart(productName, price, totalQuantity, totalPrice, userId);

        if (addedToCart) {
            response.sendRedirect("product.jsp");
        } 
    }
}