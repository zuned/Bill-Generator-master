package com.test.bill.dto;

public class UserConfigurationRequired {

    private String accountNo;

    private String cellNo;

    private String name;

    private Address address;

    private String applicableServiceTax;

    private String applicableCessTax;

    private String billStartRange;

    private String billEndRange;

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

    public String getApplicableServiceTax() {

        return this.applicableServiceTax;
    }

    public void setApplicableServiceTax(String applicableServiceTax) {

        this.applicableServiceTax = applicableServiceTax;
    }

    public String getApplicableCessTax() {

        return this.applicableCessTax;
    }

    public void setApplicableCessTax(String applicableCessTax) {

        this.applicableCessTax = applicableCessTax;
    }

    public String getBillStartRange() {

        return this.billStartRange;
    }

    public void setBillStartRange(String billStartRange) {

        this.billStartRange = billStartRange;
    }

    public String getBillEndRange() {

        return this.billEndRange;
    }

    public void setBillEndRange(String billEndRange) {

        this.billEndRange = billEndRange;
    }

}
