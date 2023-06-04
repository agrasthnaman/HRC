package com.highradius.implementation;

import com.highradius.model.Invoice;
import java.util.List;

public interface InvoiceDao {
    List<Invoice> getInvoices();
    void insertInvoice(Invoice invoice);
    void updateInvoice(int id, Invoice invoice);
    void deleteInvoice(int id);
}