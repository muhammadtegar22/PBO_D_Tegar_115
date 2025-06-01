package com.praktikum.data;

public class Items {
    private String itemname;
    private String description;
    private String location;
    private String status;

    public Items(String itemname, String description, String location) {
        this.itemname = itemname;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getItemname() {
        return itemname;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
