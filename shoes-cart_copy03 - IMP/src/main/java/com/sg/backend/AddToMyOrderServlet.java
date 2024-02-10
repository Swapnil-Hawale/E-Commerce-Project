package com.sg.backend;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sg.beans.CartBean;
import com.sg.beans.OrderBean;
import com.sg.dao.CartDAO;
import com.sg.dao.OrderDAO;
import java.util.List;

@WebServlet("/addToMyOrder")
public class AddToMyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String customerName = request.getParameter("name");

		 try {
	            int userId = (int) request.getSession().getAttribute("loggeduserId");
	            int orderId = OrderDAO.getNextOrderId();

	            List<CartBean> cartItems = CartDAO.getCartItems(userId);

	            for (CartBean cartItem : cartItems) {
	                OrderBean orderItem = new OrderBean(
	                    0, // sr_no (you can set it to 0 or assign a unique value if needed)
	                    orderId,
	                    cartItem.getProduct_name(),
	                    cartItem.getPrice(),
	                    cartItem.getTotal_quantity(),
	                    cartItem.getTotal_price(),
	                    userId
	                );

	                if (OrderDAO.addToOrder(orderItem)) {
	                    CartDAO.removeFromCart(cartItem.getCart_id());
	                }
	            }

	            response.sendRedirect("product.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
	}
}