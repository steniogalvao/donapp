package br.com.vsgdev.donapp.models;

import com.backendless.BackendlessUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Item {


    private String objectId;
    private String name;
    private String description;
    private BigDecimal value;
    private int quantity;
    private boolean situation;
    private BackendlessUser user;
    private Category category;
    private ArrayList<Institution> institutions = new ArrayList<>();


    public Item() {
    }

    public Item(String objectId, String name, String description, BigDecimal value, int quantity, boolean situation, BackendlessUser user, Category category, ArrayList<Institution> institutions) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.value = value;
        this.quantity = quantity;
        this.situation = situation;
        this.user = user;
        this.category = category;
        this.institutions = institutions;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectIdt(String objectId) {
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getSituation() {
        return situation;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }

    public BackendlessUser getBackendlessUser() {
        return user;
    }

    public void setBackendlessUser(BackendlessUser user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(ArrayList<Institution> institutions) {
        this.institutions = institutions;
    }
}
