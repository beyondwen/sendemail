package com.wenhao.sendemail.queue.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class QueueConfig {

    @Value("${email_queue}")
    private String queue;

    @Bean
    public Queue logQueue() {
        return new ActiveMQQueue(queue);
    }
}
