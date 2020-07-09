package com.lizhizhao.bizBug.service;

import com.lizhizhao.bizBug.dao.UserRepository;
import com.lizhizhao.bizBug.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 请确认事务传播配置是否符合自己的业务逻辑
 */
@Service
@Slf4j
public class UserService3 {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubUserService subUserService;

    @Transactional
    public void createUserWrong(UserEntity entity){
        createMainUser(entity);
        subUserService.createSubUserWithExceptionWrong(entity);
    }

    private void createMainUser(UserEntity entity){
        userRepository.save(entity);
        log.info("createMainUser finish");
    }

    @Transactional
    public void createUserWrong2(UserEntity entity){
        createMainUser(entity);
        try{
            subUserService.createSubUserWithExceptionWrong(entity);
        } catch (Exception ex) {
            // 虽然捕获了异常，但是因为没有开启新事务，而当前事务因为异常已经被标记为rollback了，所以最终还是会回滚。
            log.error("create sub user error:{}", ex.getMessage());
        }
    }

    @Transactional
    public void createUserRight(UserEntity entity){
        createMainUser(entity);
        try{
            subUserService.createSubUserWithExceptionRight(entity);
        } catch (Exception ex) {
            // 捕获异常，防止主方法回滚
            log.error("create sub user error:{}", ex.getMessage());
        }
    }

    //根据用户名查询用户数
    public int getUserCount(String name){
        return userRepository.findByName(name).size();
    }
}