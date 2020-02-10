package org.mak.sample.springdata.jpa.generic.repository.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mak.sample.springdata.jpa.generic.SampleSpringDataJpaGenericApplication;
import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.specification.UserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.findOne(UserSpecifications.UserIncludeUsername("mehdi")).orElse(null);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    public void testFindUsername() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.findByUsername("mehdi").orElse(null);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }

  /*  @Test
    public void testGetUsername() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.getByUsername("mehdi");
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }*/


    @Test
    public void testFindUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        userRepository.save(user);
        User savedUser = userRepository.findByUser("mehdi");
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(user.getUsername(), savedUser.getUsername());
        Assert.assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    public void testUpdateUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        User savedUser = userRepository.save(user);
        User updatedUser = Optional.of(userRepository
                .findById(user.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(entityUser -> {
                    entityUser.setUsername(user.getUsername().toUpperCase());
                    return entityUser;
                }).orElse(null);
        Assert.assertNotNull(savedUser);
        Assert.assertEquals(updatedUser.getUsername(), savedUser.getUsername().toUpperCase());
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
        User user2 = new User().builder().username("ali").password("pass").build();
        userRepository.save(user);
        userRepository.save(user2);
        Assert.assertThat(userRepository.findAll(UserSpecifications.UserIncludeUsername("i")).size(),is(2));
    }

    @Test
    public void testGetAllUser() {
        User user = new User().builder().username("mehdi").password("pass").build();
        User user2 = new User().builder().username("ali").password("pass").build();
        userRepository.save(user);
        userRepository.save(user2);
        Assert.assertNotNull(userRepository.getAll());
        for (User user3 : userRepository.getAll()) {
            System.out.println(user3.getId());
        }
    }

    @Test
    public void testdeletByUserId() {
        User user = new User().builder().username("mehdi").password("pass").build();
        User savedUser = userRepository.save(user);
        Assert.assertNotNull(savedUser.getId());
    }

    @Test
    public void testfilter() {
        User user = new User().builder().username("mehdi").password("pass").build();
        User user2 = new User().builder().username("ali").password("pass").build();
        userRepository.save(user);
        userRepository.save(user2);
        Assert.assertThat(userRepository.findAll().size(),is(1));
    }
}
