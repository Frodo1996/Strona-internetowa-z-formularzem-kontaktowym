package com.example.zadanie22_1;

public class Mail {
    private String sender;
    private String senderEmailAddress;
    private String content;

    public Mail(String sender, String senderEmailAddress, String content) {
        this.sender = sender;
        this.senderEmailAddress = senderEmailAddress;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}