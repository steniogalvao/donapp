package br.com.vsgdev.donapp.models;

import com.backendless.BackendlessUser;

import java.io.Serializable;
import java.util.Map;

/**
 * This class represent a user in the system
 */
public class User implements Serializable {


    private BackendlessUser backendlessUser;

    public User() {
        this.backendlessUser = new BackendlessUser();
    }

    public BackendlessUser getUser() {
        return this.backendlessUser;
    }

    public void setUser(BackendlessUser backendlessUser) {
        this.backendlessUser = backendlessUser;
    }

    public String getObjectId() {
        return this.backendlessUser.getObjectId();
    }

    public void setObjectId(String objectId) {
        backendlessUser.setProperty("objectId", objectId);
    }

    public String getName() {
        return (String) this.backendlessUser.getProperty("name");
    }

    public void setName(String name) {
        this.backendlessUser.setProperty("name", name);
    }

    public String getSurname() {
        return (String) this.backendlessUser.getProperty("surname");
    }

    public void setSurname(String surname) {
        this.backendlessUser.setProperty("surname", surname);
    }

    public String getEmail() {
        return (String) this.backendlessUser.getProperty("email");
    }

    public void setEmail(String email) {
        this.backendlessUser.setProperty("email", email);
    }

    public String getPassword() {
        return this.backendlessUser.getPassword();
    }

    public void setPassword(String password) {
        this.backendlessUser.setProperty("password", password);
    }

    public String getPhone() {
        return (String) this.backendlessUser.getProperty("phone");
    }

    public void setPhone(String phone) {
        this.backendlessUser.setProperty("phone", phone);
    }

    public Address getAddress() {
        return (Address) this.backendlessUser.getProperty("address");
    }

    public void setAddress(Address address) {
        this.backendlessUser.setProperty("address", address);
    }

    public Account getAccount() {
        return (Account) this.backendlessUser.getProperty("account");
    }

    public void setAccount(Account account) {
        this.backendlessUser.setProperty("account", account);
    }
}
