package com.sg.backend;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sg.dao.PdfDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

@WebServlet("/generatePDF")
public class GeneratePDFServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("order_id");

        ResultSet rs = PdfDAO.getOrderDetails(orderId);

        int totalPriceAllProducts = 0; // Variable to store total price

        try {
            // Create a new PDF document
            Document document = new Document(PageSize.A4);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();

            PdfPTable table = new PdfPTable(4);
            table.addCell("Order ID");
            table.addCell("Product Name");
            table.addCell("Product Quantity");
            table.addCell("Total Price");

            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                String productName = rs.getString("product_name");
                int productQuantity = rs.getInt("product_quantity");
                int totalPrice = rs.getInt("total_price");

                totalPriceAllProducts += totalPrice;

                table.addCell(String.valueOf(orderID));
                table.addCell(productName);
                table.addCell(String.valueOf(productQuantity));
                table.addCell(String.valueOf(totalPrice));
            }

            document.add(table);

            // Add the total price
            Paragraph totalPriceParagraph = new Paragraph("Total Products Price: " + totalPriceAllProducts);
            totalPriceParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(totalPriceParagraph);

            document.close();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=viewOrder.pdf");

            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
