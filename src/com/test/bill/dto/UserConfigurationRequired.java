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

    private String generatedBillPath;

    /**
     * airtel/idea/vodafone
     */
    private String company;

    /**
     * mobile/ broadband
     */
    private String billType;

    private String templatePath;

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

    public String getCompany() {

        return this.company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    public String getBillType() {

        return this.billType;
    }

    public void setBillType(String billType) {

        this.billType = billType;
    }

    public String getTemplatePath() {

        return this.templatePath;
    }

    public void setTemplatePath(String templatePath) {

        this.templatePath = templatePath;
    }

    public String getGeneratedBillPath() {

        return this.generatedBillPath;
    }

    public void setGeneratedBillPath(String generatedBillPath) {

        this.generatedBillPath = generatedBillPath;
    }

}
