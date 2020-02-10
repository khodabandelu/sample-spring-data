package org.mak.sample.springdata.jpa.generic.service.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.service.GenericService;

import java.util.List;

public interface UserService extends GenericService<User, String> {
    List<User> getAll();

    User findByUsername(String username);
}
