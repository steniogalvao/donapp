package br.com.vsgdev.donapp.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a category of service that can exist in the system
 * we use this to group services to make the search in the system more easy
 */
public class Category {
    private String objectId;
    private String name;
    private String description;


    public Category() {
    }

    public Category(String objectID, String name, String description) {
        this.objectId = objectID;
        this.name = name;
        this.description = description;
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
}
