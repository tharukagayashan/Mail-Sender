package com.projects.MaliSender;

import dto.MailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    private final EmailSenderService emailSenderService;

    public MailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendEmail(@RequestBody MailDto mail) {
        String response = emailSenderService.sendEmail(mail);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
