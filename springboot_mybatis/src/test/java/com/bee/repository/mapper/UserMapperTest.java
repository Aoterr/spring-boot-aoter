package com.bee.repository.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * created by guos on 2018/6/15
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {


    @Resource
    UserMapper userMapper;

    @Test
    public void count() {
        System.out.println(userMapper.count());
    }
}