package cn.lsd.rabbitmq.direct;

import cn.lsd.rabbitmq.model.UserModel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(UserModel model) {
        System.out.println("Receiver object : " + model);
    }

}
