package com.highradius.servlets;

import com.highradius.implementation.InvoiceDao;
import com.highradius.model.Invoice;
import java.util.List;

public class DataLoadingServlet {
    private InvoiceDao invoiceDao;

    public DataLoadingServlet(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public List<Invoice> getInvoices() {
        return invoiceDao.getInvoices();
    }
}
