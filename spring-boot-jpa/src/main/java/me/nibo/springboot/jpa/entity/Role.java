package me.nibo.springboot.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体
 *
 * @author NiBo
 */
@Data
@Entity
@Table(name = "sys_role")
@GenericGenerator(
    name = "system-uuid",
    strategy = "org.hibernate.id.UUIDGenerator"
)
public class Role implements Serializable {
    private static final long serialVersionUID = 4880027794922856157L;
    /**
     * 角色 id
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 启用
     */
    private Boolean enabled;

}
