package de.msz.learn.msg.web;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.msz.learn.msg.service.JmsService;
import lombok.RequiredArgsConstructor;

@RestController
@Profile("sender")
@RequiredArgsConstructor
public class SendMessageController {
    
    private final JmsService jmsService;
    
    @GetMapping("send")
    public void send(@RequestParam String message) {
        jmsService.send(message);
    }
}
