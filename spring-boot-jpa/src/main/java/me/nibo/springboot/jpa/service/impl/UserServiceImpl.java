package me.nibo.springboot.jpa.service.impl;

import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.repository.CustomUserRoleRepository;
import me.nibo.springboot.jpa.repository.UserRepository;
import me.nibo.springboot.jpa.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务接口实现
 *
 * @author NiBo
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomUserRoleRepository customUserRoleRepository;

    public UserServiceImpl(UserRepository userRepository,
            CustomUserRoleRepository customUserRoleRepository) {
        this.userRepository = userRepository;
        this.customUserRoleRepository = customUserRoleRepository;
    }

    @Override
    public List<UserRoleDto> findUserRoleList() {
        return customUserRoleRepository.listUserRole();
    }

}
