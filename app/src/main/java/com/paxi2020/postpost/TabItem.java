package com.paxi2020.postpost;

public class TabItem {

    String name;
    String num;
    String date;
    String message;

    public TabItem() {
    }

    public TabItem(String name, String num, String date, String message) {
        this.name = name;
        this.num = num;
        this.date = date;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
