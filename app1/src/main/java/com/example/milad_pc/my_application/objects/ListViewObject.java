package com.example.milad_pc.my_application.objects;

public class ListViewObject {

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
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

    private int imageResId;
    private String name;
    private String description;

    public ListViewObject() {

    }

    public ListViewObject(int imageResId, String name, String description) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
    }
}
