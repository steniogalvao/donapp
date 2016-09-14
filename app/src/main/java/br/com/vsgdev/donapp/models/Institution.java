package br.com.vsgdev.donapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a charity institution in the system, that will receive donations
 */

public class Institution {

    private String objectId;
    private String name;
    private String description;
    private Address address;
    private Account account;

    public Institution() {
    }

    public Institution(String objectId, String name, String description, Address address, Account account) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.account = account;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
