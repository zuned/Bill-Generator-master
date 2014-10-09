package com.test.bill.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MonthlyData {

    private String invoiceNo;

    private Date invoiceGeneratedDate;

    private Date billCycleStartDate;

    private Date billCycleEndDate;

    private String serviceTaxNo;

    private BigDecimal creditLimit;

    private BigDecimal previousBillAmount;

    private BigDecimal payment;

    private BigDecimal currentBillAmount;

    private BigDecimal totalBillAmount; // previousBillAmount - payment + currentBillAmount

    private Date dueDate;

    private BigDecimal balanceCarryFwd; // previousBillAmount - payment

    private BigDecimal monthlyCharges;

    private BigDecimal featureCharges;

    private BigDecimal usagesCharges;

    private BigDecimal roamingCharges;

    private BigDecimal oneTimeCharges;

    private BigDecimal otherCharges;

    private BigDecimal discounts;

    private BigDecimal serviceTax;

    private BigDecimal cess;

    private BigDecimal totalCurrentCharges;

    private BigDecimal totalAmountDue;

    public String getInvoiceNo() {

        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {

        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceGeneratedDate() {

        return this.invoiceGeneratedDate;
    }

    public void setInvoiceGeneratedDate(Date invoiceGeneratedDate) {

        this.invoiceGeneratedDate = invoiceGeneratedDate;
    }

    public Date getBillCycleStartDate() {

        return this.billCycleStartDate;
    }

    public void setBillCycleStartDate(Date billCycleStartDate) {

        this.billCycleStartDate = billCycleStartDate;
    }

    public Date getBillCycleEndDate() {

        return this.billCycleEndDate;
    }

    public void setBillCycleEndDate(Date billCycleEndDate) {

        this.billCycleEndDate = billCycleEndDate;
    }

    public String getServiceTaxNo() {

        return this.serviceTaxNo;
    }

    public void setServiceTaxNo(String serviceTaxNo) {

        this.serviceTaxNo = serviceTaxNo;
    }

    public BigDecimal getCreditLimit() {

        return this.creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {

        this.creditLimit = creditLimit;
    }

    public BigDecimal getPreviousBillAmount() {

        return this.previousBillAmount;
    }

    public void setPreviousBillAmount(BigDecimal previousBillAmount) {

        this.previousBillAmount = previousBillAmount;
    }

    public BigDecimal getPayment() {

        return this.payment;
    }

    public void setPayment(BigDecimal payment) {

        this.payment = payment;
    }

    public BigDecimal getCurrentBillAmount() {

        return this.currentBillAmount;
    }

    public void setCurrentBillAmount(BigDecimal currentBillAmount) {

        this.currentBillAmount = currentBillAmount;
    }

    public BigDecimal getTotalBillAmount() {

        return this.totalBillAmount;
    }

    public void setTotalBillAmount(BigDecimal totalBillAmount) {

        this.totalBillAmount = totalBillAmount;
    }

    public Date getDueDate() {

        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {

        this.dueDate = dueDate;
    }

    public BigDecimal getBalanceCarryFwd() {

        return this.balanceCarryFwd;
    }

    public void setBalanceCarryFwd(BigDecimal balanceCarryFwd) {

        this.balanceCarryFwd = balanceCarryFwd;
    }

    public BigDecimal getMonthlyCharges() {

        return this.monthlyCharges;
    }

    public void setMonthlyCharges(BigDecimal monthlyCharges) {

        this.monthlyCharges = monthlyCharges;
    }

    public BigDecimal getFeatureCharges() {

        return this.featureCharges;
    }

    public void setFeatureCharges(BigDecimal featureCharges) {

        this.featureCharges = featureCharges;
    }

    public BigDecimal getUsagesCharges() {

        return this.usagesCharges;
    }

    public void setUsagesCharges(BigDecimal usagesCharges) {

        this.usagesCharges = usagesCharges;
    }

    public BigDecimal getRoamingCharges() {

        return this.roamingCharges;
    }

    public void setRoamingCharges(BigDecimal roamingCharges) {

        this.roamingCharges = roamingCharges;
    }

    public BigDecimal getOneTimeCharges() {

        return this.oneTimeCharges;
    }

    public void setOneTimeCharges(BigDecimal oneTimeCharges) {

        this.oneTimeCharges = oneTimeCharges;
    }

    public BigDecimal getOtherCharges() {

        return this.otherCharges;
    }

    public void setOtherCharges(BigDecimal otherCharges) {

        this.otherCharges = otherCharges;
    }

    public BigDecimal getDiscounts() {

        return this.discounts;
    }

    public void setDiscounts(BigDecimal discounts) {

        this.discounts = discounts;
    }

    public BigDecimal getServiceTax() {

        return this.serviceTax;
    }

    public void setServiceTax(BigDecimal serviceTax) {

        this.serviceTax = serviceTax;
    }

    public BigDecimal getCess() {

        return this.cess;
    }

    public void setCess(BigDecimal cess) {

        this.cess = cess;
    }

    public BigDecimal getTotalCurrentCharges() {

        return this.totalCurrentCharges;
    }

    public void setTotalCurrentCharges(BigDecimal totalCurrentCharges) {

        this.totalCurrentCharges = totalCurrentCharges;
    }

    public BigDecimal getTotalAmountDue() {

        return this.totalAmountDue;
    }

    public void setTotalAmountDue(BigDecimal totalAmountDue) {

        this.totalAmountDue = totalAmountDue;
    }

}
