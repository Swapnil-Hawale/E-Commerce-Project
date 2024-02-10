package com.sg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sg.beans.UserBean;

public class UserDAO {
	
	//JDBC code for login
	public int userAuthentication(String userEmail, String userPassword) {
		DBCon dbCon = new DBCon();
		try(Connection con = dbCon.con()){
			PreparedStatement ps = con.prepareStatement("select * from users where userEmail=? and userPassword=?");

	         ps.setString(1, userEmail);
	         ps.setString(2, userPassword);
	         ResultSet rs = ps.executeQuery();
	         if(rs.next()) {
	        	 int userId = rs.getInt(1);
	        	 return userId;
	         }else {
	        	 return -1;
	         }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	//after register add user data in users table JDBC code
	public int addUser(UserBean userDetail) {
		//Sytsem.out.println(userDetail.ge)
		DBCon dbCon = new DBCon();
		try(Connection con = dbCon.con())
		{
			PreparedStatement ps = con.prepareStatement(
					"insert into users(userName, userEmail,userPassword, userGender, userCity) values(?,?,?,?,?)");

			ps.setString(1, userDetail.getUserEmail());
			ps.setString(2, userDetail.getUserPassword());
			ps.setString(3, userDetail.getUserName());
			ps.setString(4, userDetail.getUserGender());
			ps.setString(5, userDetail.getUserCity());
			
			ps.executeUpdate();
			
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
		
	// after logOut the user then Cart will be empty JDBC code
		 public int emptyCart(int userId) {
		        DBCon dbCon = new DBCon();
		        try (Connection con = dbCon.con()) {
		            // Delete the cart entries for the given user_id from the cart table
		            String deleteSql = "DELETE FROM cart WHERE user_id = ?";
		            PreparedStatement deleteStatement = con.prepareStatement(deleteSql);
		            deleteStatement.setInt(1, userId);
		            return deleteStatement.executeUpdate();
		        } catch (Exception e) {
		            e.printStackTrace();
		            return 0;
		        }
	}

}
