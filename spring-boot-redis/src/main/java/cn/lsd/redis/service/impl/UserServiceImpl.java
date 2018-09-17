package cn.lsd.redis.service.impl;

import cn.lsd.redis.entity.UserEntity;
import cn.lsd.redis.repository.UserRepository;
import cn.lsd.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LSD
 * @Date: 2018/9/17
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Resource
    private RedisTemplate<String, UserEntity> redisTemplate;


    /**
     * 创建用户
     * 不会对缓存做任何操作
     */
    public void createUser(UserEntity user) {
        logger.info("---------- 创建用户 ----------");
        userRepository.save(user);
    }

    /**
     * 获取用户信息
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     *
     * @param id 用户ID
     * @return 用户
     */
    public UserEntity getById(int id) {
        logger.info("---------- 获取用户 ----------");
        // 从缓存中获取用户信息
        String key = "user_" + id;
        ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            UserEntity user = operations.get(key);
            logger.info("从缓存中获取了用户 id = " + id);
            return user;
        }

        // 缓存不存在，从 DB 中获取
        UserEntity user = userRepository.findOne(id);
        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);

        return user;
    }

    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @param user 用户
     */
    public void updateUser(UserEntity user) {
        logger.info("---------- 更新用户 ----------");
        userRepository.saveAndFlush(user);
        int userId = user.getId();
        // 缓存存在，删除缓存
        String key = "user_" + userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时，从缓存中删除用户 >> " + userId);
        }
    }

    /**
     * 删除用户
     * 如果缓存中存在，删除
     */
    public void deleteById(int id) {
        logger.info("---------- 删除用户 ----------");
        userRepository.delete(id);

        // 缓存存在，删除缓存
        String key = "user_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时，从缓存中删除用户 >> " + id);
        }
    }

}
