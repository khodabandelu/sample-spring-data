package org.mak.sample.springdata.jpa.generic.repository;

import org.mak.sample.springdata.jpa.generic.domain.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;


@NoRepositoryBean
public class GenericRepositoryImpl<T extends BaseEntity, ID extends Serializable> extends AbstractRepositoryImpl<T, ID>
        implements GenericRepository<T, ID> {

    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public GenericRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

}
