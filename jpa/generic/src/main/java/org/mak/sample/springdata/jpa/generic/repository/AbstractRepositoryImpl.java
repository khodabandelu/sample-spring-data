/*
package org.mak.sample.springdata.jpa.generic.repository;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.mak.sample.springdata.jpa.generic.domain.BaseEntity;
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
public class AbstractRepositoryImpl<T extends BaseEntity, PK extends Serializable> extends SimpleJpaRepository<T, PK>
        implements GenericRepository<T, PK> {

    protected Class<T> domainClass = getDomainClass();

    private EntityManager em;

    public AbstractRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    public AbstractRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public Session getSession() {
        return em.unwrap(Session.class);
    }


    public void applyDafaultAuthorizeFilter() {

        Filter filter = getSession().enableFilter("defaultFilter");
        filter.setParameter("username", "ali");
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
        applyDafaultAuthorizeFilter();
        return super.getQuery(spec, domainClass, sort);
    }

    @Override
    public Optional<T> findById(PK pk) {
        applyDafaultAuthorizeFilter();
        return super.findById(pk);
    }
}
*/
