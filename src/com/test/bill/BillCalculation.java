package com.test.bill;

import java.math.BigDecimal;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;
import com.test.bill.dto.UserConfigurationRequired;

public class BillCalculation {

    public MobileBill generateBillDDTO(UserConfigurationRequired ucr) {

        MobileBill mobileBill = conversion(ucr);

        return mobileBill;
    }

    private MobileBill conversion(UserConfigurationRequired ucr) {

        MobileBill mobileBill = new MobileBill();

        mobileBill.setName(ucr.getName());
        mobileBill.setAccountNo(ucr.getAccountNo());
        mobileBill.setCellNo(ucr.getCellNo());
        mobileBill.setAddress(ucr.getAddress());

        mobileBill.setApplicableServiceTax(new BigDecimal(ucr.getApplicableServiceTax()));

        mobileBill.setApplicableCessTax(new BigDecimal(ucr.getApplicableCessTax()));

        return mobileBill;

    }

    private BigDecimal randomNo(int range) {

        BigDecimal rangeInBD = new BigDecimal(range);
        BigDecimal randomNoGeneration = new BigDecimal(Math.random()); // between 0 to < 1.0
        BigDecimal actualRandonNo = randomNoGeneration.multiply(rangeInBD);
        return actualRandonNo.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private MonthlyData generate(MobileBill mb) {

        MonthlyData md = new MonthlyData();
        BigDecimal billLimit = new BigDecimal(1500.00);
        md.setMonthlyCharges(new BigDecimal(699.00));
        md.setFeatureCharges(new BigDecimal(499.00));
        md.setRoamingCharges(randomNo(500));
        md.setOtherCharges(randomNo(500));

        BigDecimal totalCurrentBillCharges = md.getMonthlyCharges().add(md.getFeatureCharges()).add(md.getRoamingCharges()).add(md.getRoamingCharges()).add(md.getOtherCharges());

        return md;

    }
}
