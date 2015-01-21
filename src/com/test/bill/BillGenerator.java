package com.test.bill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.test.bill.dto.MobileBill;
import com.test.bill.dto.MonthlyData;
import com.test.bill.dto.UserConfigurationRequired;
import com.test.bill.pdf.PopulateBillPDF;
import com.test.bill.pdf.service.PDFConfigLookupService;
import com.test.bill.pdf.service.PDFProcessorService;

@SuppressWarnings("nls")
public class BillGenerator {

    private static Map<String, String> templateLocator = new HashMap<String, String>();

    static {
        templateLocator.put("airtel_mobile", "airtel_mobile.pdf");
        templateLocator.put("airtel_broadband", "airtel_broadband.pdf");
        templateLocator.put("idea_mobile", "idea_mobile.pdf");
    }

    public static void main(final String[] args) throws IOException, ParseException {

        UserConfigurationRequired ucr = PropertReader.getPropValues();
        MobileBill bill = BillCalculation.generateBillDDTO(ucr);

        generateAndSaveBills(bill, ucr);
        System.out.println(bill);
    }

    private static String getTemaplatePath(final UserConfigurationRequired ucr) {

        String path = ucr.getTemplatePath() + File.separator + templateLocator.get(ucr.getCompany() + "_" + ucr.getBillType());
        return path;
    }

    private static void generateAndSaveBills(final MobileBill bill, final UserConfigurationRequired ucr) throws IOException {

        String templateLocation = getTemaplatePath(ucr);

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

    private static void savePDF(final byte[] outputPDF, final String billPDF) throws FileNotFoundException, IOException {

        File file = new File(billPDF);
        file.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(billPDF);
        fos.write(outputPDF);
        fos.close();
    }

}
