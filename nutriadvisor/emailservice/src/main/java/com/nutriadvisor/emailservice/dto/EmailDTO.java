package com.nutriadvisor.emailservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailDTO {
    private String recipient;
    private String sender;
    private String subject;
    private String message;

    public EmailDTO(String sender,String recipient, String subject, String message){
        this.sender=sender;
        this.recipient=recipient;
        this.message=message;
        this.subject=subject;

    }
}
