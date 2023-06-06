package com.highradius.main;
import com.highradius.connection.DatabaseConnection;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;
import com.highradius.servlets.AddServlet;
import com.highradius.servlets.DataLoadingServlet;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of DatabaseConnection
        DatabaseConnection databaseConnection = new DatabaseConnection();

        // Create instances of the necessary classes
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl(databaseConnection);
        AddServlet addServlet = new AddServlet(invoiceDao);
        DataLoadingServlet dataLoadingServlet = new DataLoadingServlet(invoiceDao);

        // Create a sample invoice
        Invoice invoice1 = new Invoice("456", "789", "USA",
                "1234567890", "1234", "USD", 1000.0, new Date());

        Invoice invoice2 = new Invoice("789", "123", "UK",
                "0987654321", "5678", "GBP", 2000.0, new Date());

        // Add the invoice using the AddServlet
        addServlet.addInvoice(invoice1);
        addServlet.addInvoice(invoice2);
        // Retrieve all the invoices using the DataLoadingServlet
        List<Invoice> invoices = dataLoadingServlet.getInvoices();

        // Print the retrieved invoices
     // Print the retrieved invoices with customer order IDs
        for (int i = 0; i < invoices.size(); i++) {
            Invoice inv = invoices.get(i);
            System.out.println("Customer order ID of invoice " + (i+1) + " is: " + inv.getCustomerOrderID());
            System.out.println("Order amount of the customer " + (i+1) + " is: " + inv.getAmountInUSD());
            System.out.printf("\n");
        }

    }
}
