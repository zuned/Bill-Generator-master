package com.test.bill;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.test.bill.dto.Address;
import com.test.bill.dto.UserConfigurationRequired;

public class PropertReader {

    public UserConfigurationRequired getPropValues() throws IOException {

        UserConfigurationRequired ucr = new UserConfigurationRequired();
        Properties prop = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        // get the property value and print it out

        ucr.setAccountNo(prop.getProperty("accountNo"));
        ucr.setCellNo(prop.getProperty("cellNo"));
        ucr.setName(prop.getProperty("name"));

        Address address = new Address();
        address.setAddressLine1(prop.getProperty("addressLine1"));
        address.setAddressLine2(prop.getProperty("addressLine2"));
        address.setCity(prop.getProperty("city"));
        address.setPincode(prop.getProperty("oincode"));
        address.setState(prop.getProperty("state"));

        ucr.setAddress(address);
        ucr.setApplicableCessTax(prop.getProperty("applicableServiceTax"));
        ucr.setApplicableServiceTax(prop.getProperty("applicableCessTax"));
        ucr.setBillEndDate(prop.getProperty("billEndDate"));
        ucr.setBillEndRange(prop.getProperty("billEndRange"));
        ucr.setBillStartDate(prop.getProperty("billStartDate"));
        ucr.setBillStartRange(prop.getProperty("billStartRange"));

        return ucr;
    }

}
