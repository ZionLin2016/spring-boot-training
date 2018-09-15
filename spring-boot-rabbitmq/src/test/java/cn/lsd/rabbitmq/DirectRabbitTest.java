package cn.lsd.rabbitmq;

import cn.lsd.rabbitmq.model.UserModel;
import cn.lsd.rabbitmq.direct.DirectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectRabbitTest {
    @Autowired
    private DirectSender sender;

    @Test
    public void sendConstant() throws Exception {
        sender.sendConstant();
    }

    @Test
    public void sendOject() throws Exception {
        UserModel model=new UserModel();
        model.setName("test");
        model.setPwd("123456");
        sender.sendObject(model);
    }
}
