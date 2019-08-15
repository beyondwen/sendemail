package com.wenhao.sendemail.queue.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void send(){
        JSONObject jsonObject = new JSONObject();
        String userName = System.currentTimeMillis() + "";
        jsonObject.put("userName", userName);
        jsonObject.put("eamil", "17608009434@163.com");
        String msg = jsonObject.toJSONString();
        System.out.println("生产者向消费者发送内容:" + msg);
        jmsMessagingTemplate.convertAndSend(queue,msg);
    }
}
