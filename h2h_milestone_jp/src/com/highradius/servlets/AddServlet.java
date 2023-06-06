package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.model.Invoice;
import java.util.ArrayList;
import java.util.List;

public class AddServlet {
    private InvoiceDao invoiceDao;

    public AddServlet(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public void addInvoice(Invoice invoice) {
        invoiceDao.insertInvoice(invoice);
    }
}

