package me.nibo.springboot.jpa.dto;

import lombok.Data;

/**
 * 用户角色 DTO
 *
 * @author NiBo
 */
@Data
public class UserRoleDto {
    private String userId;
    private String username;
    private Integer age;
    private String roleId;
    private String roleName;
}
