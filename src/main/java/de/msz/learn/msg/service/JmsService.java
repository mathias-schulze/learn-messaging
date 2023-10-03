package de.msz.learn.msg.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import de.msz.learn.msg.config.JmsConfig;
import de.msz.learn.msg.domain.SimpleMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JmsService {
    
    private final JmsTemplate jms;
    
    public void send(String message) {
        jms.convertAndSend(JmsConfig.REQUEST_QUEUE, SimpleMessage.builder().text(message).build());
    }
}
