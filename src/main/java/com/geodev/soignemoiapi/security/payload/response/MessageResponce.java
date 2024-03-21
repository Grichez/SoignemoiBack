package com.geodev.soignemoiapi.security.payload.response;


public class MessageResponce {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;


    public MessageResponce(String message) {
        this.message = message;
    }
}
