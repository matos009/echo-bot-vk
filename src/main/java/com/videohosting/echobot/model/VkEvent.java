package com.videohosting.echobot.model;

public class VkEvent {
    private String type;
    private Long group_id;
    private String secret;
    private MessageObject object;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MessageObject getObject() {
        return object;
    }

    public void setObject(MessageObject object) {
        this.object = object;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    // Вложенный класс для поля object
    public static class MessageObject {
        private Message message;  // <-- Вот оно правильно!

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    // Вложенный класс для самого сообщения
    public static class Message {
        private Long from_id;
        private String text;

        public Long getFrom_id() {
            return from_id;
        }

        public void setFrom_id(Long from_id) {
            this.from_id = from_id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}