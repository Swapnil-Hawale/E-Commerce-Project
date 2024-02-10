package com.sg.backend;

import java.io.IOException;
import java.io.PrintWriter;


import com.sg.dao.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter out = resp.getWriter();
      UserDAO userDao =new UserDAO();
      String userEmail = req.getParameter("userEmail");
      String userPass = req.getParameter("userPass");
      
      int userId=userDao.userAuthentication(userEmail, userPass);
      
      try {
    	 if(userId==-1) {
    		 out.print("<h3 style='color:red'> Email id and password did not match </h3>");
             RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
             rd.include(req, resp); // provide the request and responce object
    		 
    	 }else {
    		 HttpSession session = req.getSession();
             session.setAttribute("loggedInUser", userEmail); // we are displayed the user email at product page
             session.setAttribute("loggeduserId", userId);
             RequestDispatcher rd = req.getRequestDispatcher("/product.jsp");
             rd.include(req, resp);
    	 }

      } catch (Exception e) {
         e.printStackTrace();

         out.print(" " + e.getMessage() + " ");

         RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
         rd.include(req, resp);
      }

   }
}