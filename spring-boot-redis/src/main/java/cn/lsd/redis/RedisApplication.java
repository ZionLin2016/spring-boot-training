package cn.lsd.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @Author: LSD
 * @Date: 2018/9/17
 */
@SpringBootApplication
public class RedisApplication {

	private static final Logger logger = LoggerFactory.getLogger(RedisApplication.class);

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(RedisApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			logger.info(beanName);
		}
	}
}
