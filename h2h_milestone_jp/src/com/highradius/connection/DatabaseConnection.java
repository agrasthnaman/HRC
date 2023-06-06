package com.highradius.connection;

import com.highradius.model.Invoice;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private List<Invoice> invoices;

    public DatabaseConnection() {
        this.invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}
