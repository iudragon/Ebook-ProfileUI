package com.projects.sharath.readerprofileui;

public class BooksModel {
    //IMAGE OF BOOK
    private int image;
    //NAME OF BOOK AND PROGRESS NUM
    private String name, progressnum;
    //PROGRESS BAR
    private int progress;

    public BooksModel() {
    }

    public BooksModel(int image, String name, String progressnum, int progress) {
        this.image = image;
        this.name = name;
        this.progressnum = progressnum;
        this.progress = progress;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgressnum() {
        return progressnum;
    }

    public void setProgressnum(String progressnum) {
        this.progressnum = progressnum;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
