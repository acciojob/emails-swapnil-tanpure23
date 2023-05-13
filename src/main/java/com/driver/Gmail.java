package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

   private int inboxCapacity;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;
    
    public Gmail(String emailId) {
        super(emailId);
        this.inboxCapacity = 50; // default capacity
        this.inbox = new ArrayList<Mail>();
        this.trash = new ArrayList<Mail>();
    }
    
    public void receiveMail(Date date, String senderId, String message) {
        if (inbox.size() >= inboxCapacity) {
            Mail oldestMail = inbox.get(0);
            inbox.remove(0);
            trash.add(oldestMail);
        }
        Mail newMail = new Mail(date, senderId, message);
        inbox.add(newMail);
    }
    
    public void deleteMail(String message) {
        for (Mail mail : inbox) {
            if (mail.getMessage().equals(message)) {
                inbox.remove(mail);
                trash.add(mail);
                break; // stop searching after first match is found
            }
        }
    }
    
    public String findLatestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(inbox.size()-1).getMessage();
    }
    
    public String findOldestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(0).getMessage();
    }
    
    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            Date mailDate = mail.getDate();
            if (mailDate.compareTo(start) >= 0 && mailDate.compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }
    
    public int getInboxSize() {
        return inbox.size();
    }
    
    public int getTrashSize() {
        return trash.size();
    }
    
    public void emptyTrash() {
        trash.clear();
    }
    
    public int getInboxCapacity() {
        return inboxCapacity;
    }
    
    private class Mail {
        private Date date;
        private String senderId;
        private String message;
        
        public Mail(Date date, String senderId, String message) {
            this.date = date;
            this.senderId = senderId;
            this.message = message;
        }
        
        public Date getDate() {
            return date;
        }
        
        public String getSenderId() {
            return senderId;
        }
        
        public String getMessage() {
            return message;
        }
    }
}
