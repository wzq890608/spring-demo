package com.wzq.springboot.redis;

import com.wzq.springboot.domain.User;
import com.wzq.springboot.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisService {
    @Autowired
    private RedisService redisService;

    @Test
    public void testString() throws Exception {
        redisService.set("neo", "ityouknow");
        Assert.assertEquals("ityouknow", redisService.get("neo"));
    }

    @Test
    public void testObj() throws Exception {
        User user=new User("wzq", "123", "hhh", "cn");
        redisService.set("user",user);
        User userR=(User) redisService.get("user");
        System.out.println(userR.toString());
    }
}
