package cn.lsd.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MyBatisApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisApplication.class);

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(MyBatisApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			logger.info(beanName);
		}
	}
}
