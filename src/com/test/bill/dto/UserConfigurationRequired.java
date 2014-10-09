package com.test.bill.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UserConfigurationRequired {

    private String accountNo;

    private String cellNo;

    private String name;

    private Address address;

    private String applicableServiceTax;

    private String applicableCessTax;

    private String billStartRange;

    private String billEndRange;

    private String billStartDate;

    private String billEndDate;

    public String getAccountNo() {

        return accountNo;
    }

    public void setAccountNo(String accountNo) {

        this.accountNo = accountNo;
    }

    public String getCellNo() {

        return cellNo;
    }

    public void setCellNo(String cellNo) {

        this.cellNo = cellNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    public String getApplicableServiceTax() {

        return applicableServiceTax;
    }

    public void setApplicableServiceTax(String applicableServiceTax) {

        this.applicableServiceTax = applicableServiceTax;
    }

    public String getApplicableCessTax() {

        return applicableCessTax;
    }

    public void setApplicableCessTax(String applicableCessTax) {

        this.applicableCessTax = applicableCessTax;
    }

    public String getBillStartRange() {

        return billStartRange;
    }

    public void setBillStartRange(String billStartRange) {

        this.billStartRange = billStartRange;
    }

    public String getBillEndRange() {

        return billEndRange;
    }

    public void setBillEndRange(String billEndRange) {

        this.billEndRange = billEndRange;
    }

    public String getBillStartDate() {

        return billStartDate;
    }

    public void setBillStartDate(String billStartDate) {

        this.billStartDate = billStartDate;
    }

    public String getBillEndDate() {

        return billEndDate;
    }

    public void setBillEndDate(String billEndDate) {

        this.billEndDate = billEndDate;
    }

}
