package me.nibo.springboot.jpa.service;

import me.nibo.springboot.jpa.dto.UserRoleDto;

import java.util.List;

/**
 * 用户业务接口
 *
 * @author NiBo
 */
public interface UserService {
    List<UserRoleDto> findUserRoleList();
}
