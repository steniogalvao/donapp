package br.com.vsgdev.donapp.models;


import java.util.Date;

/**
 * This class represent a sale in the system
 */
public class Sale {

    private String objectID;
    private User user;
    private Item item;
    private Date date;

    public Sale(String objectId, User user, Item item, Date date) {
        this.objectID = objectId;
        this.user = user;
        this.item = item;
        this.date = date;
    }

    public String getObjectId() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
