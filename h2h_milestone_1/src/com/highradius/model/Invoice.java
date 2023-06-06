package com.highradius.model;

import java.util.Date;

public class Invoice {
    private String customerOrderID;
    private String salesOrg;
    private String distributionChannel;
    private String customerNumber;
    private String companyCode;
    private String orderCurrency;
    private double amountInUSD;
    private Date orderCreationDate;

    public Invoice(String customerOrderID, String salesOrg, String distributionChannel, String customerNumber,
                   String companyCode, String orderCurrency, double amountInUSD, Date orderCreationDate) {
        this.customerOrderID = customerOrderID;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.customerNumber = customerNumber;
        this.companyCode = companyCode;
        this.orderCurrency = orderCurrency;
        this.amountInUSD = amountInUSD;
        this.orderCreationDate = orderCreationDate;
    }

    // Getters and Setters for the fields
    public String getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(String customerOrderID) {
        this.customerOrderID = customerOrderID;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public double getAmountInUSD() {
        return amountInUSD;
    }

    public void setAmountInUSD(double amountInUSD) {
        this.amountInUSD = amountInUSD;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }
}
