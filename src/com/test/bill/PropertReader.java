package com.test.bill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.test.bill.dto.Address;
import com.test.bill.dto.UserConfigurationRequired;

public class PropertReader {

    @SuppressWarnings("nls")
    public static UserConfigurationRequired getPropValues() throws IOException {

        UserConfigurationRequired ucr = new UserConfigurationRequired();
        Properties prop = new Properties();
        String propFileName = "config.properties";

        // InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        FileInputStream fis = new FileInputStream("C:\\workspace\\workspace_ha-phase2_dev\\Bill-Generator\\config.properties");

        if (fis == null)
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");

        prop.load(fis);

        // get the property value and print it out

        ucr.setAccountNo(prop.getProperty("accountNo"));
        ucr.setCellNo(prop.getProperty("cellNo"));
        ucr.setName(prop.getProperty("name"));

        Address address = new Address();
        address.setAddressLine1(prop.getProperty("addressLine1"));
        address.setAddressLine2(prop.getProperty("addressLine2"));
        address.setCity(prop.getProperty("city"));
        address.setPincode(prop.getProperty("pincode"));
        address.setState(prop.getProperty("state"));
        ucr.setAddress(address);

        ucr.setApplicableCessTax(prop.getProperty("applicableServiceTax"));
        ucr.setApplicableServiceTax(prop.getProperty("applicableCessTax"));
        ucr.setBillEndRange(prop.getProperty("billEndRange"));
        ucr.setBillStartRange(prop.getProperty("billStartRange"));

        ucr.setBillType(prop.getProperty("billType"));
        ucr.setCompany(prop.getProperty("company"));
        ucr.setTemplatePath(prop.getProperty("templatePath"));
        ucr.setGeneratedBillPath(prop.getProperty("generatedBillPath"));

        return ucr;
    }

}
