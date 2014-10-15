package com.test.bill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;
import com.test.bill.dto.UserConfigurationRequired;
import com.test.bill.pdf.PopulateBillPDF;
import com.test.bill.pdf.service.PDFConfigLookupService;
import com.test.bill.pdf.service.PDFProcessorService;

public class BillGenerator {

    private static Map<String, String> templateLocator = new HashMap<String, String>();

    static {
        templateLocator.put("airtel_mobile", "airtel_mobile.pdf");
        templateLocator.put("airtel_broadband", "airtel_broadband.pdf");
        templateLocator.put("idea_mobile", "idea_mobile.pdf");
    }

    public static void main(String[] args) throws IOException {

        PropertReader propertReader = new PropertReader();
        UserConfigurationRequired ucr = propertReader.getPropValues();
        MobileBill bill = BillCalculation.generateBillDDTO(ucr);

        generateAndSaveBills(bill, ucr);
        System.out.println(bill);
    }

    private static String getTemaplatePath(UserConfigurationRequired ucr) {

        String path = ucr.getTemplatePath() + File.separator + templateLocator.get(ucr.getCompany() + "_" + ucr.getBillType());

        return path;

    }

    private static void generateAndSaveBills(MobileBill bill, UserConfigurationRequired ucr)
                                                                                            throws IOException {

        String templateLocation = getTemaplatePath(ucr);

        // String templateLocation = "C:\\workspace\\workspace_ha-phase2_dev\\Bill-Generator\\templates\\idea_mobile.pdf";
        byte[] pdfTemplate = PDFConfigLookupService.getTemplateByLocation(templateLocation);

        for (MonthlyData data : bill.getMonthlyDataList()) {
            Map<String, String> populatedMap = PopulateBillPDF.populateMapUsingEnrollmentDTO(bill, data);
            byte[] outputPDF = null;
            String billPrefix = "_" + templateLocator.get(ucr.getCompany() + "_" + ucr.getBillType());
            String billPDF = ucr.getGeneratedBillPath() + File.separator + data.getBillCycleStartDate().getMonth() + billPrefix;
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
