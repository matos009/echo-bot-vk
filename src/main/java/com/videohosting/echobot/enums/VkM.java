package com.videohosting.echobot.enums;

public enum VkM {
    SENDMESSAGE("message_new"),
    CONFIRMATION("confirmation");

    private final String method;

    VkM(String s){this.method = s;}

    public String getMethod() {
        return method;
    }

}
