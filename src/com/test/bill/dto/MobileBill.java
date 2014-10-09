package com.test.bill.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MobileBill {

    private String accountNo;

    private String cellNo;

    private String name;

    private Address address;

    private BigDecimal applicableServiceTax;

    private BigDecimal applicableCessTax;

    private Date billStartRange;

    private Date billEndRange;

    private Date billStartDate;

    private Date billEndDate;

    private MonthlyData monthlyData;

    public String getAccountNo() {

        return this.accountNo;
    }

    public void setAccountNo(String accountNo) {

        this.accountNo = accountNo;
    }

    public String getCellNo() {

        return this.cellNo;
    }

    public void setCellNo(String cellNo) {

        this.cellNo = cellNo;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Address getAddress() {

        return this.address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    public MonthlyData getMonthlyData() {

        return this.monthlyData;
    }

    public void setMonthlyData(MonthlyData monthlyData) {

        this.monthlyData = monthlyData;
    }

    public BigDecimal getApplicableServiceTax() {

        return this.applicableServiceTax;
    }

    public void setApplicableServiceTax(BigDecimal applicableServiceTax) {

        this.applicableServiceTax = applicableServiceTax;
    }

    public BigDecimal getApplicableCessTax() {

        return this.applicableCessTax;
    }

    public void setApplicableCessTax(BigDecimal applicableCessTax) {

        this.applicableCessTax = applicableCessTax;
    }

    public Date getBillStartRange() {

        return this.billStartRange;
    }

    public void setBillStartRange(Date billStartRange) {

        this.billStartRange = billStartRange;
    }

    public Date getBillEndRange() {

        return this.billEndRange;
    }

    public void setBillEndRange(Date billEndRange) {

        this.billEndRange = billEndRange;
    }

    public Date getBillStartDate() {

        return this.billStartDate;
    }

    public void setBillStartDate(Date billStartDate) {

        this.billStartDate = billStartDate;
    }

    public Date getBillEndDate() {

        return this.billEndDate;
    }

    public void setBillEndDate(Date billEndDate) {

        this.billEndDate = billEndDate;
    }

}
