package com.lizhizhao.bizBug.controller;

import com.lizhizhao.bizBug.service.UserService2;
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
@RequestMapping("/user2")
public class UserController2 {

    @Autowired
    private UserService2 userService2;

    @GetMapping("wrong1")
    public void wrong1(@RequestParam("name") String name) {
        userService2.createUserWrong1(name);
    }

    @GetMapping("wrong2")
    public void wrong2(@RequestParam("name") String name) {
        try {
            userService2.createUserWrong2(name);
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
    }

    @GetMapping("right1")
    public void right1(@RequestParam("name") String name) {
        try {
            userService2.createUserRight1(name);
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
    }

    @GetMapping("right2")
    public void right2(@RequestParam("name") String name) {
        try {
            userService2.createUserRight2(name);
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
    }

}
