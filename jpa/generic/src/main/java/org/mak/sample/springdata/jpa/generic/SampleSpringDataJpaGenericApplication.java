package org.mak.sample.springdata.jpa.generic;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.GenericRepositoryImpl;
import org.mak.sample.springdata.jpa.generic.service.security.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = GenericRepositoryImpl.class)
@EnableAspectJAutoProxy(exposeProxy = true)
public class SampleSpringDataJpaGenericApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SampleSpringDataJpaGenericApplication.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        UserService service = applicationContext.getBean(UserService.class);
        User user = new User().builder().username("mehdi").password("pass").build();
        User user2 = new User().builder().username("ali").password("pass").build();
        service.save(user);
        service.save(user2);
        System.out.println(service.findAll().size());
        System.out.println(service.getAll().size());
        System.out.println(service.findByUsername("mehdi").getUsername());
    }

}

