package me.nibo.springboot.jpa.dto;

import lombok.Data;

/**
 * $END$description
 *
 * @author bo.ni
 */
@Data
public class RoleDto {
    private String roleId;
    private String roleName;

    public RoleDto() {}

    public RoleDto(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
