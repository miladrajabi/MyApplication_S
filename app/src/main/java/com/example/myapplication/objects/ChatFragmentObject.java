package com.example.myapplication.objects;

public class ChatFragmentObject {
    String message;
    Boolean me;
    String date;
    Boolean seen;
    int type;

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_DATE = 1;

    public ChatFragmentObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ChatFragmentObject(String message) {
        this.message = message;
    }

    public Boolean getMe() {
        return me;
    }

    public void setMe(Boolean me) {
        this.me = me;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
