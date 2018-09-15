package cn.lsd.rabbitmq.direct;

import cn.lsd.rabbitmq.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@Component
public class DirectSender {

	private static final Logger logger = LoggerFactory.getLogger(DirectSender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void sendConstant() {
		String context = "begin test send direct constant msg " + new Date();

		this.rabbitTemplate.convertAndSend("hello", context);
	}
	public void sendObject(UserModel model) {
		logger.info("Sender: begin test send direct object msg " + model.toString());
		this.rabbitTemplate.convertAndSend("object", model);
	}

}