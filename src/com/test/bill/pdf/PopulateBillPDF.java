package com.test.bill.pdf;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;

public class PopulateBillPDF {

    @SuppressWarnings("nls")
    public static final Map<String, String> populateMapUsingEnrollmentDTO(final MobileBill bill, final MonthlyData monthlyData) {

        Map<String, String> map = new HashMap<String, String>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        map.put("accountNumber", bill.getAccountNo());

        map.put("mobileNumber", bill.getCellNo());

        map.put("name", bill.getName());

        map.put("addressLine1", bill.getAddress().getAddressLine1());
        map.put("addressLine2", bill.getAddress().getAddressLine2());
        map.put("city", bill.getAddress().getCity());
        map.put("state", bill.getAddress().getState());
        map.put("zip", bill.getAddress().getPincode());

        map.put("invoiceNumber", monthlyData.getInvoiceNo());

        map.put("invoiceDate", formatter.format(monthlyData.getInvoiceGeneratedDate()));

        map.put("invoiceDateFrom", formatter.format(monthlyData.getBillCycleStartDate()));

        map.put("invoiceDateTo", formatter.format(monthlyData.getBillCycleEndDate()));

        map.put("serviceTaxNumber", monthlyData.getServiceTaxNo());

        map.put("creditLimit", monthlyData.getCreditLimit().toPlainString());

        map.put("previousBillAmount", monthlyData.getPreviousBillAmount().toPlainString());

        map.put("payment", monthlyData.getPayment().toPlainString());

        map.put("currentCharges", monthlyData.getTotalCurrentChargesWithTax().toPlainString());

        map.put("totalCurrentCharges", monthlyData.getTotalCurrentChargesWithTax().toPlainString());

        map.put("totalAmountDue", monthlyData.getTotalAmountDueInThisCycle().toPlainString());

        map.put("totalAmountAfterDueDate", monthlyData.getTotalAmountDueInThisCycle().add(monthlyData.getLateFee()).toPlainString());

        map.put("dueDate", formatter.format(monthlyData.getDueDate()));

        map.put("balanceCarried", monthlyData.getBalanceCarryFwd().toPlainString());

        map.put("monthlyCharges", monthlyData.getMonthlyCharges().toPlainString());

        map.put("featureCharges", monthlyData.getFeatureCharges().toPlainString());

        map.put("usageCharges", monthlyData.getUsagesCharges().toPlainString());

        map.put("roamingCharges", monthlyData.getRoamingCharges().toPlainString());

        map.put("oneTimeCharges", monthlyData.getOneTimeCharges().toPlainString());

        map.put("adjustments", monthlyData.getOtherCharges().toPlainString());

        map.put("otherCharges", monthlyData.getOtherCharges().toPlainString());

        map.put("discount", monthlyData.getDiscounts().toPlainString());

        map.put("serviceTax", monthlyData.getServiceTax().toPlainString());

        map.put("ecHec", monthlyData.getCess().toPlainString());

        map.put("lateFee", monthlyData.getLateFee().toPlainString());

        map.put("totalCurrentChargesWithoutTax", monthlyData.getTotalCurrentChargesWithoutTax().toPlainString());

        return map;

    }
}