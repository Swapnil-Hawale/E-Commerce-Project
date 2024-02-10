package com.sg.backend;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.sg.dao.UserDAO;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	
    	 HttpSession session = request.getSession(false);
         if (session != null) {
             int userId = (int) session.getAttribute("loggeduserId");
             UserDAO userDAO = new UserDAO();
             userDAO.emptyCart(userId); // Delete cart entries for the current user
             session.invalidate(); // Invalidate the session
         }
         response.sendRedirect("product.jsp"); // Redirect to the product page
    	
    
    }
}