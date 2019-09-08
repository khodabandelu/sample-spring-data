package org.mak.sample.springdata.jpa.generic.repository.security;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.mak.sample.springdata.jpa.querydsl.domain.security.QUser;

public class UserExpressionQueryDsl {
    public static BooleanExpression UserIncludeUsername(String username) {
        return QUser.user.username.like(username);
    }
}
