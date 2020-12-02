package me.nibo.springboot.jpa.dto;

import lombok.Data;

import java.util.List;

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
    private List<RoleDto> roles;

    public UserRoleDto() {}

    public UserRoleDto(String userId, String username, Integer age, List<RoleDto> roles) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.roles = roles;
    }

    // public UserRoleDto(String userId, String username, Integer age, RoleDto roleDto) {
    //     this.userId = userId;
    //     this.username = username;
    //     this.age = age;
    //     this.roles.add(roleDto);
    // }
}
