package me.nibo.springboot.jpa.repository;

import me.nibo.springboot.jpa.dto.UserRoleDto;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * 自定义用户角色数据接口
 *
 * @author NiBo
 */
@NoRepositoryBean
public interface CustomUserRoleRepository {
    List<UserRoleDto> listUserRole();

}
