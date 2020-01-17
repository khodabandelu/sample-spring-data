package org.mak.sample.springdata.jpa.generic;

import org.mak.sample.springdata.jpa.generic.repository.GenericRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = GenericRepositoryImpl.class)
public class SampleSpringDataJpaGenericApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringDataJpaGenericApplication.class, args);
	}

}

