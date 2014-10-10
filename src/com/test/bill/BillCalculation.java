package com.test.bill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;
import com.test.bill.dto.UserConfigurationRequired;

public class BillCalculation {

    public static MobileBill generateBillDDTO(UserConfigurationRequired ucr) {

        MobileBill mobileBill = conversion(ucr);
        List<MonthlyData> list = new ArrayList<MonthlyData>();

        for (int i = 0; i < 12; i++) {
            MonthlyData currentMonthlyData = new MonthlyData();

            MonthlyData previousMonthlyData;

            if (i == 0) {
                previousMonthlyData = null;
            } else {
                previousMonthlyData = list.get(i - 1);
            }

            currentMonthlyData = configureMonthlyCycle(currentMonthlyData, previousMonthlyData, mobileBill);

            currentMonthlyData = generate(mobileBill, currentMonthlyData);
            list.add(currentMonthlyData);
        }
        mobileBill.setMonthlyDataList(list);

        return mobileBill;
    }

    private static MonthlyData configureMonthlyCycle(MonthlyData current, MonthlyData previous, MobileBill bill) {

        if (previous == null) {

            current.setPayment(new BigDecimal("1645.78"));
            current.setPreviousBillAmount(new BigDecimal("1645.78"));

            current.setBillCycleStartDate(bill.getBillStartRange());

            Random rnd = new Random();
            int invoiceNo = 50460000 + rnd.nextInt(999389999);
            String iNo = StringUtils.leftPad(new Integer(invoiceNo).toString(), 10, '0');
            current.setInvoiceNo(iNo);

        } else {

            current.setPayment(previous.getTotalAmountDueInThisCycle());
            current.setPreviousBillAmount(previous.getTotalAmountDueInThisCycle());

            Random rnd = new Random();
            int in = 3008290 + rnd.nextInt(99973999);
            int invoiceNo = new Integer(previous.getInvoiceNo()) + in;
            String iNo = StringUtils.leftPad(new Integer(invoiceNo).toString(), 10, '0');
            current.setInvoiceNo(iNo);

            Calendar first = new GregorianCalendar();
            first.setTime(previous.getBillCycleEndDate());
            first.add(Calendar.MONTH, 1);
            first.set(Calendar.DAY_OF_MONTH, 1);
            current.setBillCycleStartDate(first.getTime());

        }

        current.setCreditLimit(new BigDecimal("2500.00"));

        Calendar cal = new GregorianCalendar();
        cal.setTime(current.getBillCycleStartDate());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        current.setBillCycleEndDate(cal.getTime());

        Calendar third = new GregorianCalendar();
        third.setTime(current.getBillCycleEndDate());
        third.add(Calendar.MONTH, 1);
        third.set(Calendar.DAY_OF_MONTH, 1);
        current.setInvoiceGeneratedDate(third.getTime());

        Calendar fourth = new GregorianCalendar();
        fourth.setTime(current.getInvoiceGeneratedDate());
        fourth.add(Calendar.DAY_OF_MONTH, 15);
        current.setDueDate(fourth.getTime());

        current.setServiceTaxNo("AAACB2100PST007");

        current.setCess(bill.getApplicableCessTax());
        current.setServiceTax(bill.getApplicableServiceTax());
        current.setBalanceCarryFwd(current.getPreviousBillAmount().subtract(current.getPayment()));
        current.setOneTimeCharges(new BigDecimal("0.00"));
        current.setDiscounts(new BigDecimal("0.00"));
        current.setOtherCharges(new BigDecimal("0.00"));

        return current;
    }

    private static MobileBill conversion(UserConfigurationRequired ucr) {

        MobileBill mobileBill = new MobileBill();

        mobileBill.setName(ucr.getName());
        mobileBill.setAccountNo(ucr.getAccountNo());
        mobileBill.setCellNo(ucr.getCellNo());
        mobileBill.setAddress(ucr.getAddress());
        mobileBill.setApplicableServiceTax(new BigDecimal(ucr.getApplicableServiceTax()));
        mobileBill.setApplicableCessTax(new BigDecimal(ucr.getApplicableCessTax()));

        Calendar start = new GregorianCalendar();
        start.set(2014, 3, 1);
        mobileBill.setBillStartRange(start.getTime());

        Calendar end = new GregorianCalendar();
        end.set(2015, 2, 31);
        mobileBill.setBillEndRange(end.getTime());

        return mobileBill;

    }

    private static BigDecimal randomNo(int range) {

        BigDecimal rangeInBD = new BigDecimal(range);
        BigDecimal randomNoGeneration = new BigDecimal(Math.random()); // between 0 to < 1.0
        BigDecimal actualRandonNo = randomNoGeneration.multiply(rangeInBD);
        return actualRandonNo.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private static MonthlyData generate(MobileBill mb, MonthlyData md) {

        md.setMonthlyCharges(new BigDecimal("599.00"));
        md.setFeatureCharges(new BigDecimal("399.00"));
        md.setRoamingCharges(randomNo(300));
        md.setUsagesCharges(randomNo(300));

        BigDecimal totalCurrentBillChargesWithoutTax = md.getMonthlyCharges().add(md.getFeatureCharges()).add(md.getRoamingCharges()).add(md.getRoamingCharges()).add(md.getUsagesCharges()).setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal serviceTax = totalCurrentBillChargesWithoutTax.multiply(md.getServiceTax()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal cess = serviceTax.multiply(md.getCess()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal totalCurrentBillChargesWithTax = totalCurrentBillChargesWithoutTax.add(serviceTax).add(cess);

        BigDecimal totalAmountDueInThisCycle = totalCurrentBillChargesWithTax.subtract(md.getPayment()).add(md.getPreviousBillAmount());

        md.setCess(cess);
        md.setServiceTax(serviceTax);
        md.setTotalCurrentChargesWithoutTax(totalCurrentBillChargesWithoutTax);
        md.setTotalCurrentChargesWithTax(totalCurrentBillChargesWithTax);
        md.setTotalAmountDueInThisCycle(totalAmountDueInThisCycle);

        return md;

    }
}
