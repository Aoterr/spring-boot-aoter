package com.coreplus.aps;

import com.coreplus.aps.bean.UserEntity;
import com.coreplus.aps.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@MapperScan("com.coreplus.aps.mapper")
public class ApsApplication {


    @Autowired
    UserMapper userMapper;

    @RequestMapping("")
    public String index() {
        return "success";
    }

    @RequestMapping("getAll")
    public List<UserEntity> getAll() {
        List<UserEntity> list = userMapper.getAll();
        return list;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApsApplication.class, args);
    }
}
