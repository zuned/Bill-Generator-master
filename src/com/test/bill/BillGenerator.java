package com.test.bill;

import java.io.IOException;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.UserConfigurationRequired;

public class BillGenerator {

    public static void main(String[] args) throws IOException {

        PropertReader propertReader = new PropertReader();

        UserConfigurationRequired ucr = propertReader.getPropValues();

        MobileBill bill = BillCalculation.generateBillDDTO(ucr);

        System.out.println(bill);

    }

}
