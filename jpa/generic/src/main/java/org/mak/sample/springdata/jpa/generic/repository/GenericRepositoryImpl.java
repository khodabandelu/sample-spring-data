package org.mak.sample.springdata.jpa.generic.repository;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public class GenericRepositoryImpl<T , ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements GenericRepository<T, ID> {

    protected Class<T> domainClass = getDomainClass();

    private EntityManager em;

    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    public GenericRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public Session getSession() {
        return em.unwrap(Session.class);
    }

    public void applyDefaultFilter() {
        Filter filter = getSession().enableFilter("defaultFilter");
        filter.setParameter("username", "aaaaaa");
        //filter.setParameter("orgId", SecurityUtility.getCurrentOrganizationStructure().getId());
        //TODO change to realm
//        filter.setParameter("orgId", 1);
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(domainClass.getName());
        return criteria.list();
    }

    @Override
    protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {
//        applyDefaultFilter();
        return super.getQuery(spec, domainClass, sort);
    }

    @Override
    public Optional<T> findById(ID id) {
//        applyDefaultFilter();
        return super.findById(id);
    }

//    @DefaultFilter(enabled = false)
    @Override
    public List<T> findAll(String username) {
        return super.findAll();
    }
}
