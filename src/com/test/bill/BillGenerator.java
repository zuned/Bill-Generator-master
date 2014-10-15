package com.test.bill;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;
import com.test.bill.dto.UserConfigurationRequired;
import com.test.bill.pdf.PopulateBillPDF;
import com.test.bill.pdf.service.PDFConfigLookupService;
import com.test.bill.pdf.service.PDFProcessorService;

public class BillGenerator {

    public static void main(String[] args) throws IOException {

        PropertReader propertReader = new PropertReader();
        UserConfigurationRequired ucr = propertReader.getPropValues();
        MobileBill bill = BillCalculation.generateBillDDTO(ucr);
        generateAndSaveBills(bill);
        System.out.println(bill);
    }

    private static void generateAndSaveBills(MobileBill bill)
                                                             throws IOException {

        String templateLocation = "C:\\workspace\\workspace_ha-phase2_dev\\Bill-Generator\\templates\\idea_mobile.pdf";
        byte[] pdfTemplate = PDFConfigLookupService.getTemplateByLocation(templateLocation);

        for (MonthlyData data : bill.getMonthlyDataList()) {
            Map<String, String> populatedMap = PopulateBillPDF.populateMapUsingEnrollmentDTO(bill, data);
            byte[] outputPDF = null;
            String billPDF = "C:\\workspace\\workspace_ha-phase2_dev\\Bill-Generator\\bill\\bill_" + data.getBillCycleStartDate().getMonth() + ".pdf";
            try {
                outputPDF = PDFProcessorService.writePDF(populatedMap, pdfTemplate);
                if (outputPDF != null) {
                    outputPDF = PDFProcessorService.freezePDF(outputPDF);
                    savePDF(outputPDF, billPDF);
                }
            } catch (Exception e) {
                System.out.println("Error occured while writing and freezing pdf :" + templateLocation);
            }
        }
    }

    private static void savePDF(byte[] outputPDF, String billPDF)
                                                                 throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream(billPDF);
        fos.write(outputPDF);
        fos.close();
    }

}
