package cn.lsd.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
public class TopicSender {

	private static final Logger logger = LoggerFactory.getLogger(TopicSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send1() {
		String context = "begin test send topic msg 1";
		logger.info("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchangeTest", "topicTest.message", context);
	}

	public void send2() {
		String context = "begin test send topic msg 2";
		logger.info("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchangeTest", "topicTest.messages", context);
	}

}