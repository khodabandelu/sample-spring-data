package org.mak.sample.springdata.jpa.oracle.repository.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mak.sample.springdata.jpa.oracle.domain.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserEntityRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    public void testSaveUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.findByUsername("mehdi").orElse(null);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    public void testGetUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.findByUsername("mehdi").orElse(null);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    public void testDeleteUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        userRepository.delete(user);
    }

    @Test
    public void testfindAllUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        Assert.assertNotNull(userRepository.findAll());
    }

    @Test
    public void testdeletByUserId() {
        User user = new User().builder().username("mehdi").password("pass").build();
        User savedUser = userRepository.save(user);
        Assert.assertNotNull(savedUser.getId());
    }
}
