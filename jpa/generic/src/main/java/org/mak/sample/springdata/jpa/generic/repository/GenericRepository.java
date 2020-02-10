package org.mak.sample.springdata.jpa.generic.repository;

import org.mak.sample.springdata.jpa.generic.config.aspect.HibernateFilter;
import org.mak.sample.springdata.jpa.generic.config.aspect.FilterParam;
import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    public List<T> getAll();

    @HibernateFilter(c = User.class, parameters = {@FilterParam(name = "userId"), @FilterParam(name = "orgId")}, enabled = true)
    public List<T> findAll(String username);


}
