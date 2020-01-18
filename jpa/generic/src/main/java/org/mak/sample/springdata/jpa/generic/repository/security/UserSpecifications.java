package org.mak.sample.springdata.jpa.generic.repository.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.domain.security.User_;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<User> UserIncludeUsername(String username) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(User_.username),"%"+ username+"%");
        };
    }
}
