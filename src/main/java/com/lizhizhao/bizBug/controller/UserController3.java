package com.lizhizhao.bizBug.controller;

import com.lizhizhao.bizBug.entity.UserEntity;
import com.lizhizhao.bizBug.service.UserService2;
import com.lizhizhao.bizBug.service.UserService3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小心 Spring 的事务可能没有生效
 * @author lizhizhao
 * @since 2020-07-09 13:51
 */
@Slf4j
@RestController
@RequestMapping("/user3")
public class UserController3 {

    @Autowired
    private UserService3 userService3;

    @GetMapping("wrong")
    public int wrong(@RequestParam("name") String name) {
        try {
            userService3.createUserWrong(new UserEntity(name));
        } catch (Exception ex) {
            log.error("createUserWrong failed, reason:{}", ex.getMessage());
        }
        return userService3.getUserCount(name);
    }

    @GetMapping("wrong2")
    public void wrong2(@RequestParam("name") String name) {
        try {
            userService3.createUserWrong2(new UserEntity(name));
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
    }

    @GetMapping("right")
    public void right(@RequestParam("name") String name) {
        try {
            userService3.createUserRight(new UserEntity(name));
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
    }

}
