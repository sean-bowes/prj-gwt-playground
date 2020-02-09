package com.koisoftware.monet.client.record;

import java.io.Serializable;

/**
 * Created by sb90320 on 12/15/2014.
 */
public class AddressRecord implements Serializable {

    private static final long serialVersionUID = 4843722694274166599L;
    private int addressId;
    private int customerId;
    private String activeStatus;
    private String addressType;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private int addressNotesId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getAddressNotesId() {
        return addressNotesId;
    }

    public void setAddressNotesId(int addressNotesId) {
        this.addressNotesId = addressNotesId;
    }
}
