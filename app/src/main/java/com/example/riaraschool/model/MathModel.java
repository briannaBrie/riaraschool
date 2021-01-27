package com.example.riaraschool.model;

public class MathModel {
    private String title;
    private String question;
    private String image1;
    private String image2;
    private int choice1;
    private int choice2;
    private int choice3;

    public MathModel(String title, String question, String image1, String image2, int choice1, int choice2, int choice3) {
        this.title = title;
        this.question = question;
        this.image1 = image1;
        this.image2 = image2;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public int getChoice1() {
        return choice1;
    }

    public void setChoice1(int choice1) {
        this.choice1 = choice1;
    }

    public int getChoice2() {
        return choice2;
    }

    public void setChoice2(int choice2) {
        this.choice2 = choice2;
    }

    public int getChoice3() {
        return choice3;
    }

    public void setChoice3(int choice3) {
        this.choice3 = choice3;
    }
}
