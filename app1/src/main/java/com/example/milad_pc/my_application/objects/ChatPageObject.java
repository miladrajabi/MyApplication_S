package com.example.milad_pc.my_application.objects;

public class ChatPageObject {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public ChatPageObject(String message) {
        this.message = message;
    }
    public ChatPageObject() {
    }
}
