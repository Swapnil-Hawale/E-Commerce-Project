package com.sg.backend;

import java.io.IOException;
import java.io.PrintWriter;


import com.sg.beans.UserBean;
import com.sg.dao.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		String userPass = req.getParameter("userPass");
		String userGender = req.getParameter("userGender");
		String userCity = req.getParameter("userCity");
		
		UserBean userDetail = new UserBean(userName,userEmail,userPass,userGender,userCity);
		
		UserDAO userDAO = new UserDAO();
		
		try {
			int registered =userDAO.addUser(userDetail);

//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoes_cart", "root",
//					"swapnil@123");
//
//			PreparedStatement ps = con.prepareStatement(
//					"insert into users(userName, userEmail,userPassword, userGender, userCity) values(?,?,?,?,?)");
//
//			ps.setString(1, userName);
//			ps.setString(2, userEmail);
//			ps.setString(3, userPass);
//			ps.setString(4, userGender);
//			ps.setString(5, userCity);
//
//			int count = ps.executeUpdate();

			if (registered==1) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> User Register Successfully </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User Not Register Due To Some Error </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();

			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception Occured:" + e.getMessage() + "</h3>");

			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
	}
}
