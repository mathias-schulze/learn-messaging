package de.msz.learn.msg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import com.rabbitmq.jms.admin.RMQDestination;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;

@Configuration
@Profile("rabbit")
public class RabbitJmsConfig extends JmsConfig {
    
    @Bean
    public JmsTemplate jmsTemplate() {
        
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        
        return jmsTemplate;
    }
    
    @Bean
    public ConnectionFactory connectionFactory() {
        
      RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
      connectionFactory.setUsername("guest");
      connectionFactory.setPassword("guest");
      connectionFactory.setVirtualHost("/");
      connectionFactory.setHost("localhost");
      connectionFactory.setPort(5672);
      
      return connectionFactory;
    }
    
    @Bean
    public Destination requestDestination() {
        return new RMQDestination(REQUEST_QUEUE, true, false);
    }
    
    @Bean
    public Destination responseDestination() {
        return new RMQDestination(RESPONSE_QUEUE, true, false);
    }
    
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        
        return converter;
    }
}
