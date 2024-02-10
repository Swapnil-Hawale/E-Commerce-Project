package com.sg.dao;

import java.util.ArrayList;
import java.util.List;
import com.sg.beans.CartBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {
    public static boolean addToCart(String productName, int price, int totalQuantity, int totalPrice, int userId) {
        Connection conn = DBCon.con(); // Use the connection from DBCon
         
        //add products inside order table
        
        try {
            // Check if the product already exists in the cart or database
            String checkSql = "SELECT * FROM cart WHERE product_name = ?";
            PreparedStatement checkStatement = conn.prepareStatement(checkSql);
            checkStatement.setString(1, productName);
            ResultSet checkResult = checkStatement.executeQuery();

            if (checkResult.next()) {
                // Product already exists, update the quantity
                int existingQuantity = checkResult.getInt("total_quantity");
                int newQuantity = existingQuantity + totalQuantity;

                // Update the quantity in the cart table
                String updateSql = "UPDATE cart SET total_quantity = ?, total_price = ? WHERE product_name = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                updateStatement.setInt(1, newQuantity);
                updateStatement.setInt(2, totalPrice * newQuantity);
                updateStatement.setString(3, productName);
                updateStatement.executeUpdate();
            } else {
                // Product doesn't exist, insert a new entry in the cart table
                String insertSql = "INSERT INTO cart (user_id, product_name, price, total_quantity, total_price) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertSql);

                insertStatement.setInt(1, userId);
                insertStatement.setString(2, productName);
                insertStatement.setInt(3, price);
                insertStatement.setInt(4, totalQuantity);
                insertStatement.setInt(5, totalPrice);
                insertStatement.executeUpdate();
            }

            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
        
        //get the cart items from cart table
    
        public static List<CartBean> getCartItems(int userId) {
            Connection conn = DBCon.con(); // Use the connection from DBCon
            List<CartBean> cartItems = new ArrayList<>();
            
            int totalPriceAllProducts = 0; // Variable to store total price
            try {
                String getCartItemsSql = "SELECT * FROM cart WHERE user_id = ?";
                PreparedStatement getCartItemsStatement = conn.prepareStatement(getCartItemsSql);
                getCartItemsStatement.setInt(1, userId);
                ResultSet cartItemsResult = getCartItemsStatement.executeQuery();
                
                while (cartItemsResult.next()) {
                    int cartId = cartItemsResult.getInt("cart_id");
                    String productName = cartItemsResult.getString("product_name");
                    int price = cartItemsResult.getInt("price");
                    int totalQuantity = cartItemsResult.getInt("total_quantity");
                    int totalPrice = cartItemsResult.getInt("total_price");
                    
                    totalPriceAllProducts = totalPriceAllProducts + totalPrice;
                    
                    CartBean cartItem = new CartBean(cartId, userId, productName, price, totalQuantity, totalPrice);
                    cartItems.add(cartItem);
                }
                
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return cartItems;
        }
           

        //for remove products inside cart table JDBC code
            public static void removeFromCart(int cartId) {
                Connection conn = DBCon.con(); // Use the connection from DBCon
                try {
                    // Delete the item from the cart table
                    String deleteSql = "DELETE FROM cart WHERE cart_id = ?";
                    PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                    deleteStatement.setInt(1, cartId);
                    deleteStatement.executeUpdate();

                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            
    }
}
