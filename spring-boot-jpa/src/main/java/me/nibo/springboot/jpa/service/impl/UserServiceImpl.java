package me.nibo.springboot.jpa.service.impl;

import java.util.List;
import me.nibo.springboot.jpa.dto.UserQueryParamDto;
import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.repository.CustomUserRoleRepository;
import me.nibo.springboot.jpa.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务接口实现
 *
 * @author NiBo
 */
@Service
public class UserServiceImpl implements UserService {

  private final CustomUserRoleRepository customUserRoleRepository;

  public UserServiceImpl(CustomUserRoleRepository customUserRoleRepository) {
    this.customUserRoleRepository = customUserRoleRepository;
  }

  @Override
  public List<UserRoleDto> findUserRoleList(UserQueryParamDto queryParam) {
    return customUserRoleRepository.listUserRole(queryParam);
  }

}
