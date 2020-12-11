package com.yhxd.test;

import com.yhxd.modular.system.dao.ConfigDao;
import com.yhxd.modular.system.dao.UserDao;
import com.yhxd.modular.system.entity.Config;
import com.yhxd.modular.system.entity.User;
import com.yhxd.utils.RedissonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MyTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ConfigDao configDao;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("王少甫");
        user.setPassword("123456");
//        this.userDao.save(user);
//
//        User user1 = new User();
//        user1.setUsername("李四");
//        user1.setPassword("654321");
//        this.userDao.save(user1);
//
//        Optional<User> optionalUser = this.userDao.findById(user.getId());
//        User u = optionalUser.isPresent() ? optionalUser.get() : null;
//        u.setPassword("abcde");
//        userDao.save(u);

//        Config config1 = new Config();
//        config1.setConfName("测试1");
//        this.configDao.save(config1);
//
//        Config config2 = new Config();
//        config2.setConfName("测试2");
//        this.configDao.save(config2);

//        PageRequest pageRequest = PageRequest.of(0, 2);
//        List<User> userList = this.userDao.findAll(pageRequest).getContent();
//        for (User user : userList) {
//            System.out.println(user.getUsername());
//        }

        RedissonUtils.putObject("123", user);
    }
}
