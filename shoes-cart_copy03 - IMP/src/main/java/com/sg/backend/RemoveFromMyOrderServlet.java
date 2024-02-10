package com.sg.backend;

import java.io.IOException;

import com.sg.dao.CartDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removeFromMyOrder")
public class RemoveFromMyOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int orderId = Integer.parseInt(req.getParameter("order_id"));
	    int orderID = Integer.parseInt(req.getParameter("order_id"));
	    CartDAO.removeFromCart(orderID);
        resp.sendRedirect("cart.jsp");

	}

}
