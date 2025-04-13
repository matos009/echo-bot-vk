package com.videohosting.echobot.enums;

public enum Urls {
    SEND_MESSAGE("messages.send");

    private final String method;

    Urls(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
