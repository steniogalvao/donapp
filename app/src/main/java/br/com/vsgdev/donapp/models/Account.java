package br.com.vsgdev.donapp.models;

/**
 * This class represents an account of an institution or a person in the system
 */
public class Account {
    private String objectId;
    private String bank;
    private String agency;
    private String account;
    private String type;

    public Account(String objectId, String bank, String agency, String account, String type) {
        this.objectId = objectId;
        this.bank = bank;
        this.agency = agency;
        this.account = account;
        this.type = type;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
