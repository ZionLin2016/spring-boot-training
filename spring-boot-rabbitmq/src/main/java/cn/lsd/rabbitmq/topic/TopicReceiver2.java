package cn.lsd.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
@RabbitListener(queues = "topicTest.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("TopicTest Receiver2  : " + message);
    }

}
