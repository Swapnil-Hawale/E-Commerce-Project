package com.sg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sg.beans.ProductBean;

public class ProductDAO {

	//JDBC code for fetch the product details from products table in product page
	
    public List<ProductBean> getProducts() {
        List<ProductBean> products = new ArrayList<>();
        DBCon dbCon = new DBCon();

        try (Connection con = dbCon.con()) {
            PreparedStatement ps = con.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductBean product = new ProductBean(rs.getString("productName"), rs.getInt("productPrice"), rs.getString("productImage"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}

