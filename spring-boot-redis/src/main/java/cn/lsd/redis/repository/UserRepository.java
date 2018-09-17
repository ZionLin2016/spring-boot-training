package cn.lsd.redis.repository;

import cn.lsd.redis.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LSD
 * @Date: 2018/9/17
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
