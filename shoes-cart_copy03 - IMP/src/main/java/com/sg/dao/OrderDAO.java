package com.sg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sg.beans.OrderBean;
import java.util.List;
import java.util.ArrayList;

public class OrderDAO {
	
	// for order_id
    public static int getNextOrderId() {
        Connection conn = DBCon.con();
        int orderId = 0;
        try {
            // Fetch the current order_id from the database
            String selectOrderIdSql = "SELECT MAX(order_id) FROM orders";
            PreparedStatement selectOrderIdStatement = conn.prepareStatement(selectOrderIdSql);
            ResultSet orderIdResultSet = selectOrderIdStatement.executeQuery();
            if (orderIdResultSet.next()) {
                orderId = orderIdResultSet.getInt(1) + 1; // Increment order_id by 1
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    //for add the products in orders table
    public static boolean addToOrder(OrderBean orderItem) {
        Connection conn = DBCon.con();

        try {
            String insertSql = "INSERT INTO orders (order_id, product_name, price, product_quantity, total_price, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);
            
            insertStatement.setInt(1, orderItem.getOrder_id());
            insertStatement.setString(2, orderItem.getProduct_name());
            insertStatement.setInt(3, orderItem.getPrice());
            insertStatement.setInt(4, orderItem.getTotal_quantity());
            insertStatement.setInt(5, orderItem.getTotal_price());
            insertStatement.setInt(6, orderItem.getUser_id());

            int rowsAffected = insertStatement.executeUpdate();

            conn.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
        //for display the product after buy the products in MyOrder.jsp page
        public static List<OrderBean> getOrders() {
            List<OrderBean> orders = new ArrayList<>();
            Connection conn = DBCon.con();

            try {
                String sql = "SELECT order_id, SUM(product_quantity) as product_quantity, SUM(total_price) AS total_price FROM orders GROUP BY order_id;";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int productQuantity = rs.getInt("product_quantity");
                    int totalPrice = rs.getInt("total_price");

                    OrderBean order = new OrderBean(0, orderId, "", 0, productQuantity, totalPrice, 0);
                    orders.add(order);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return orders;
        }
        
        // for Cancel Order JDBC code
        public static void removeFromMyOrder(int orderId) {
            Connection conn = DBCon.con(); // Use the connection from DBCon
            try {
                // Delete the item from the cart table
                String deleteSql = "DELETE FROM cart WHERE order_id = ?";
                PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                deleteStatement.setInt(1, orderId);
                deleteStatement.executeUpdate();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        
        
             
        //for view order JDBC code
            public static List<OrderBean> getOrderDetails(int orderId) {
                List<OrderBean> orderDetails = new ArrayList<>();
                Connection conn = DBCon.con();
                try {
                    String sql = "SELECT * FROM orders WHERE order_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, orderId);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                      //  int sr_no = rs.getInt("sr_no");
                        String productName = rs.getString("product_name");
                       // int price = rs.getInt("price");
                        int total_quantity = rs.getInt("product_quantity");
                        int total_price = rs.getInt("total_price");
                      //  int user_id = rs.getInt("user_id");

                        OrderBean orderItem = new OrderBean( 0, orderId, productName, 0, total_quantity, total_price, 0);
                        orderDetails.add(orderItem);
                    }

                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return orderDetails;

    }
}
