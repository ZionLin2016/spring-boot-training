package cn.lsd.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
@RabbitListener(queues = "topicTest.message")
public class TopicReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("TopicTest Receiver1  : " + message);
    }

}
