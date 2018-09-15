package cn.lsd.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 *
 * 每个发到 fanout 类型交换器的消息都会分到所有绑定的队列上去
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue AMessage() {
        return new Queue("fanoutTest.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanoutTest.B");
    }


    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchangeTest");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

}
