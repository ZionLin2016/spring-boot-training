package cn.lsd.schedule.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * cron表达式
 *                 字段名                 允许的值                        允许的特殊字符
 *                秒                         0-59                               , - * /
 *                分                         0-59                               , - * /
 *                小时                     0-23                               , - * /
 *                日                         1-31                               , - * ? / L W C
 *                月                         1-12 or JAN-DEC         , - * /
 *                周几                     1-7 or SUN-SAT           , - * ? / L C #
 *                年 (可选字段)     empty, 1970-2099      , - * /
 *
 * @Author: LSD
 * @Date: 2018/9/16
 */
@Component
public class ScheduledController {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledController.class);


    @Scheduled(cron = "*/1 * * * * ?")
    public void checkState1() {
        logger.info(">>>>> 冒个泡 <<<<<");
    }



}
