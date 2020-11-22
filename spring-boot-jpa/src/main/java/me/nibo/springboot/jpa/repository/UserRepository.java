package me.nibo.springboot.jpa.repository;

import me.nibo.springboot.jpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户数据接口
 *
 * @author NiBo
 */
@Repository
public interface UserRepository
    extends JpaRepository<User, String> {}
