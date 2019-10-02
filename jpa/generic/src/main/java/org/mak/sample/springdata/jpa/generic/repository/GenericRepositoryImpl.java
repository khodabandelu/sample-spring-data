package org.mak.sample.springdata.jpa.generic.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;


public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements GenericRepository<T, ID> {

    private EntityManager em;

    protected Class<T> domainClass = getDomainClass();

    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        em = entityManager;
    }

    public Session getSession() {
        return em.unwrap(Session.class);
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(domainClass.getName());
        return criteria.list();
    }

}
