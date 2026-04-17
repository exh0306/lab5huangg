/**
 * Project: Lab5
 * Purpose Details: Web Service and HMAC
 * Course : IST 242
 * Author: Emlety Huang
 * Date Developed: 4/15/26
 * Last Date Changed: 4/17/26
 * Revision: 4/17/26
 *
 */
package com.lab5;

public class Message {
    private String message; //text
    private String hmac; //security hash

    public Message() {
    }

    public Message(String message, String hmac) {
        this.message = message;
        this.hmac = hmac;
    }

    public String getMessage() { //return message
        return message;
    }

    public String getHmac() { //return HMAC
        return hmac;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }
}