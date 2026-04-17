package com.lab5;

public class Message {
    private String message;
    private String hmac;

    public Message() {
    }

    public Message(String message, String hmac) {
        this.message = message;
        this.hmac = hmac;
    }

    public String getMessage() {
        return message;
    }

    public String getHmac() {
        return hmac;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }
}