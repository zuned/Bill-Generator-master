package com.test.bill.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MobileBill {

    private String accountNo;

    private String cellNo;

    private String name;

    private Address address;

    private BigDecimal applicableServiceTax;

    private BigDecimal applicableCessTax;

    private Date billStartRange;

    private Date billEndRange;

    // private Date billStartDate;

    // private Date billEndDate;

    private List<MonthlyData> monthlyDataList;

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

    public List<MonthlyData> getMonthlyDataList() {

        return this.monthlyDataList;
    }

    public void setMonthlyDataList(List<MonthlyData> monthlyDataList) {

        this.monthlyDataList = monthlyDataList;
    }

    @Override
    public String toString() {

        return "MobileBill [accountNo=" + accountNo + ", cellNo=" + cellNo + ", name=" + name + ", address=" + address + ", applicableServiceTax=" + applicableServiceTax + ", applicableCessTax=" + applicableCessTax + ", billStartRange="
            + billStartRange + ", billEndRange=" + billEndRange + ", monthlyDataList=" + monthlyDataList + "]";
    }

}
