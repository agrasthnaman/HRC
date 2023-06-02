package com.highradius.implementation;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {
    private DatabaseConnection databaseConnection;

    public InvoiceDaoImpl() {
        databaseConnection = new DatabaseConnection();
    }

    @Override
    public List<Invoice> getInvoices() {
        return databaseConnection.getInvoices();
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        databaseConnection.addInvoice(invoice);
    }

    @Override
    public void updateInvoice(int id, Invoice invoice) {
        // Implement the update logic here using the provided id and invoice object
        // You can choose to update the invoice in the databaseConnection or perform any other necessary operations
        // ...
    }

    @Override
    public void deleteInvoice(int id) {
        // Implement the delete logic here using the provided id
        // You can choose to delete the invoice from the databaseConnection or perform any other necessary operations
        // ...
    }
}
