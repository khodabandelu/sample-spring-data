package org.mak.sample.springdata.jpa.generic.repository.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;

public interface UserRepositoryCustom {
    User findByUser(String username);
    User getByUsername(String username);
}
