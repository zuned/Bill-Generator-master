package com.test.bill.dto;

public class Address {

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String pincode;

    private String state;

    public String getAddressLine1() {

        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {

        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {

        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {

        this.addressLine2 = addressLine2;
    }

    public String getCity() {

        return this.city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getPincode() {

        return this.pincode;
    }

    public void setPincode(String pincode) {

        this.pincode = pincode;
    }

    public String getState() {

        return this.state;
    }

    public void setState(String state) {

        this.state = state;
    }

    @Override
    public String toString() {

        return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
    }

}
