package me.nibo.springboot.jpa.repository;

import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.entity.QRole;
import me.nibo.springboot.jpa.entity.QUser;
import me.nibo.springboot.jpa.entity.QUserRole;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * CustomUserRoleRepositoryImpl
 *
 * @author NiBo
 */
@Repository
public class CustomUserRoleRepositoryImpl implements CustomUserRoleRepository {

    private final EntityManager em;

    public CustomUserRoleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UserRoleDto> listUserRole() {
        JPAQuery<UserRoleDto> query = new JPAQuery<>(em);
        query.select(Projections.bean(
                    UserRoleDto.class,
                    QUser.user.id.as("userId"),
                    QUser.user.username,
                    QUser.user.age,
                    QRole.role.id.as("roleId"),
                    QRole.role.roleName
                    )).from(QUser.user, QUserRole.userRole, QRole.role);
        BooleanExpression expression = QUser.user.id.eq(QUserRole.userRole.userId)
            .and(QUserRole.userRole.roleId.eq(QRole.role.id));
        query.where(expression);
        return query.fetch();
    }

}
