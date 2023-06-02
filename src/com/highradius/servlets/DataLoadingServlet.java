package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DataLoadingServlet extends HttpServlet {
    private InvoiceDao invoiceDao;

    @Override
    public void init() throws ServletException {
        super.init();
        invoiceDao = new InvoiceDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call the getInvoices() method of the InvoiceDao to retrieve all invoices
        List<Invoice> invoices = invoiceDao.getInvoices();

        // Set the retrieved invoices as an attribute in the request
        request.setAttribute("invoices", invoices);

        // Forward the request to a JSP page for displaying the data
        request.getRequestDispatcher("invoices.jsp").forward(request, response);
    }
}
