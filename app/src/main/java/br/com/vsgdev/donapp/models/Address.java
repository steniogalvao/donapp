package br.com.vsgdev.donapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Address {

    private String objectId;
    private String country;
    private String state;
    private String city;
    private String neighboard;
    private String street;
    private String number;
    private String complement;

    public Address() {
    }

    public Address(String objectId, String country, String state, String city, String neighboard, String street, String number, String complement) {
        this.objectId = objectId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighboard = neighboard;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getObjectId() {
        return getObjectId();
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighboard() {
        return neighboard;
    }

    public void setNeighboard(String neighboard) {
        this.neighboard = neighboard;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

}
