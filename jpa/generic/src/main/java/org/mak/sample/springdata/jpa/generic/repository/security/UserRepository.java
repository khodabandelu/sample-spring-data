package org.mak.sample.springdata.jpa.generic.repository.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User, String>, UserRepositoryCustom {
    Optional<User> findByUsername(String username);
}
