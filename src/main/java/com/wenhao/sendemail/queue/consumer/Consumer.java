package com.wenhao.sendemail.queue.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String toEmail;

    @JmsListener(destination = "sendemail")
    public void receiver(String msg) throws Exception {
        System.out.println("消费者接受，生产者内容:" + msg);
        if (StringUtils.isEmpty(msg)) {
            return;
        }
        JSONObject jsonObject = JSONObject.parseObject(msg);
        String userName = jsonObject.getString("userName");
        String eamil = jsonObject.getString("eamil");
        sendSimpleMail(eamil, userName);
    }

    public void sendSimpleMail(String eamil, String userName) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(eamil);
        message.setTo(toEmail);
        message.setSubject("蚂蚁课堂|每特教育 新学员提醒");
        message.setText("祝贺您,成为了我们" + userName + ",学员!");
        javaMailSender.send(message);
        System.out.println("邮件发送完成," + JSONObject.toJSONString(message));
    }
}
