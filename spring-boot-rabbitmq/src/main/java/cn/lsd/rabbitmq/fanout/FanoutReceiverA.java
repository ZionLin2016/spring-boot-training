package cn.lsd.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
@RabbitListener(queues = "fanoutTest.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanoutTest Receiver A  : " + message);
    }

}
