package com.example.chatbot2;

public class ChatMessage {
    private String content;
    private boolean fromUser;

//    public ChatMessage(String content, boolean isSentByUser) {
//        this.content = content;
//        this.isSentByUser = isSentByUser;
//    }

    public String getContent() {
        return content;
    }

    public ChatMessage(String content, boolean fromUser) {
        this.content = content;
        this.fromUser = fromUser;
    }

    public boolean isFromUser() {
        return fromUser;
    }
}
