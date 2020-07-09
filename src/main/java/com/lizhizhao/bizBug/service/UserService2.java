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
 * 事务即便生效也不一定能回滚
 */
@Service
@Slf4j
public class UserService2{

    @Autowired
    private UserRepository userRepository;
    //异常无法传播出方法，导致事务无法回滚
    @Transactional
    public void createUserWrong1(String name){
        try {
            userRepository.save(new UserEntity(name));
            throw new RuntimeException("error");
        } catch (Exception ex) {
            log.error("create user failed", ex);
        }
    }
    
    //即使出了受检异常也无法让事务回滚
    @Transactional
    public void createUserWrong2(String name) throws IOException {
        userRepository.save(new UserEntity(name));
        otherTask();
    }

    //因为文件不存在，一定会抛出一个IOException
    private void otherTask()throws IOException {
        Files.readAllLines(Paths.get("file-that-not-exist"));
    }


    // 第一，如果你希望自己捕获异常进行处理的话，也没关系，可以手动设置让当前事务处于回滚状态：
    @Transactional
    public void createUserRight1(String name) {
        try {
            userRepository.save(new UserEntity(name));
            throw new RuntimeException("error");
        } catch (Exception ex) {
            log.error("create user failed", ex);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }


    //第二，在注解中声明，期望遇到所有的 Exception 都回滚事务（来突破默认不回滚受检异常的限制）：
    @Transactional(rollbackFor = Exception.class)
    public void createUserRight2(String name)throws IOException {
        userRepository.save(new UserEntity(name));
        otherTask();
    }
}