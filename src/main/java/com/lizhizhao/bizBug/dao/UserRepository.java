package com.lizhizhao.bizBug.dao;

import com.lizhizhao.bizBug.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List findByName(String name);
}