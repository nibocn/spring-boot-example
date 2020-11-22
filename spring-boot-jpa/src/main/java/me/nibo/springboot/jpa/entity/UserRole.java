package me.nibo.springboot.jpa.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色实体
 *
 * @author NiBo
 */
@Data
@Entity
@Table(name = "sys_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 4880027794922856341L;
    @Id
    private String userId;
    @Id
    private String roleId;
}
