package de.msz.learn.msg.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JmsConfig {
    
    public static final String REQUEST_QUEUE = "request-queue";
    public static final String RESPONSE_QUEUE = "response-queue";
}
