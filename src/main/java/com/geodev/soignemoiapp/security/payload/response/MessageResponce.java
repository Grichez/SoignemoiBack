package com.geodev.soignemoiapp.security.payload.response;

import lombok.Getter;
import lombok.Setter;


public class MessageResponce {

    private String message;


    public MessageResponse() {}

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
