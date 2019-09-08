package org.mak.sample.springdata.jpa.basic.repository.security;

import org.mak.sample.springdata.jpa.basic.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
