package com.nutriadvisor.emailservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Email {

    private String recipient;
    private String sender;
    private String subject;
    private String message;

    public Email(String sender,String recipient, String subject, String message){
        this.sender=sender;
        this.recipient=recipient;
        this.message=message;
        this.subject=subject;

    }
}
