package cn.lsd.redis;

import cn.lsd.redis.entity.UserEntity;
import cn.lsd.redis.service.UserService;
import cn.lsd.redis.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @Author: LSD
 * @Date: 2018/9/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testCache() {
        UserEntity user = new UserEntity("admin", "10086@qq.com");
        userService.createUser(user);
        Integer id = user.getId();

        UserEntity user1 = userService.getById(id); // 第1次访问
        assertEquals(user1.getUsername(), "admin");

        UserEntity user2 = userService.getById(id); // 第2次访问
        assertEquals(user2.getUsername(), "admin");
        user.setUsername("lsd");
        userService.updateUser(user);
        UserEntity user3 = userService.getById(id); // 第3次访问
        assertEquals(user3.getUsername(), "lsd");

        userService.deleteById(id);
        assertNull(userService.getById(id));
    }
}