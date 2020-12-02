package me.nibo.springboot.jpa.dto;

import me.nibo.springboot.jpa.entity.QUser;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import lombok.Data;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * $END$description
 *
 * @author bo.ni
 */
@Data
public class UserQueryParamDto {
    private String username;
    private Integer age;

    public Predicate getPredicate() {
        BooleanBuilder where = new BooleanBuilder(null);
        if (!StringUtils.isEmpty(username)) {
            where.and(QUser.user.username.like("%" + username + "%"));
        }
        if (Objects.nonNull(age)) {
            where.and(QUser.user.age.eq(age));
        }
        return where.getValue();
    }

}
