package org.mak.sample.springdata.jpa.generic.service.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.GenericRepository;
import org.mak.sample.springdata.jpa.generic.repository.security.UserRepository;
import org.mak.sample.springdata.jpa.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected GenericRepository<User, String> getGenericRepository() {
        return userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

}