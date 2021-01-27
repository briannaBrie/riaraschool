package com.example.riaraschool.model;

public class EnglishModel {
    private String title;
    private String image1;
    private String image2;
    private String image3;

    public EnglishModel() {
    }

    public EnglishModel(String title, String image1, String image2, String image3) {
        this.title = title;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
}
