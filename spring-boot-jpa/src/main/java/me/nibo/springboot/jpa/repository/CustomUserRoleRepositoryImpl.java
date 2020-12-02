package me.nibo.springboot.jpa.repository;

import me.nibo.springboot.jpa.dto.RoleDto;
import me.nibo.springboot.jpa.dto.UserQueryParamDto;
import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.entity.QRole;
import me.nibo.springboot.jpa.entity.QUser;
import me.nibo.springboot.jpa.entity.QUserRole;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
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
    public List<UserRoleDto> listUserRole(UserQueryParamDto queryParam) {
        ConstructorExpression<RoleDto> roleExpr = Projections.constructor(RoleDto.class,
            QRole.role.id.as("roleId"),
            QRole.role.roleName
        );

        ConstructorExpression<UserRoleDto> userRoleExpr = Projections.constructor(UserRoleDto.class,
            QUser.user.id.as("userId"),
            QUser.user.username,
            QUser.user.age,
            GroupBy.list(roleExpr)
        );

        JPAQuery<UserRoleDto> query = new JPAQuery<>(em);
        query.from(QUser.user)
            .innerJoin(QUserRole.userRole)
            .on(QUser.user.id.eq(QUserRole.userRole.userId))
            .leftJoin(QRole.role)
            .on(QUserRole.userRole.roleId.eq(QRole.role.id));

        query.where(queryParam.getPredicate());

        // 写法一
        return query.transform(GroupBy.groupBy(QUser.user.id).list(userRoleExpr));
        // 写法二
        // return query.transform(GroupBy.groupBy(QUser.user.id).list(
        //     Projections.bean(UserRoleDto.class,
        //         QUser.user.id.as("userId"),
        //         QUser.user.username,
        //         QUser.user.age,
        //         GroupBy.list(
        //             Projections.bean(
        //                 RoleDto.class,
        //                 QRole.role.id.as("roleId"),
        //                 QRole.role.roleName)
        //         ).as("roles")
        //     )
        // ));

        // BooleanExpression expression = QUser.user.id.eq(QUserRole.userRole.userId)
        //     .and(QUserRole.userRole.roleId.eq(QRole.role.id));
        // query.where(expression);
        // return query.fetch();
    }

}
