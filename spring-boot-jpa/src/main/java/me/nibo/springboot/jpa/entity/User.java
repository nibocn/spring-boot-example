package me.nibo.springboot.jpa.entity;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体
 *
 * @author NiBo
 */
@Data
@Table(name = "sys_user")
@Entity
@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
public class User implements Serializable {
    private static final long serialVersionUID = 4880027794922856323L;
    /**
     * 用户 id
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String username;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
}
