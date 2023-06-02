package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private InvoiceDao invoiceDao;

    @Override
    public void init() throws ServletException {
        super.init();
        invoiceDao = new InvoiceDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the invoice data from the request parameters
        String invoiceNumber = request.getParameter("invoiceNumber");
        String customerName = request.getParameter("customerName");
        // ... (Retrieve other invoice data)

        // Create an Invoice object with the retrieved data
        Invoice invoice = new Invoice(invoiceNumber, customerName);
        // ... (Set other properties of the invoice)

        // Call the insertInvoice() method of the InvoiceDao to add the invoice
        invoiceDao.insertInvoice(invoice);

        // Redirect the user to a success page or perform any other desired actions
        response.sendRedirect("success.jsp");
    }
}
