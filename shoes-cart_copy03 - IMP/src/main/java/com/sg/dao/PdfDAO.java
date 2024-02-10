package com.sg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PdfDAO {
    public static ResultSet getOrderDetails(String orderId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBCon.con(); // Use the DBCon class to get the connection
            stmt = conn.createStatement();
            String sql = "SELECT * FROM orders WHERE order_id = " + orderId;
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
