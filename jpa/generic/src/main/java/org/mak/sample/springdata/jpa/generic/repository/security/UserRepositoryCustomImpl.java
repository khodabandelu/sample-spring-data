package org.mak.sample.springdata.jpa.generic.repository.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.GenericRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryCustomImpl extends GenericRepositoryImpl<User,String> implements UserRepositoryCustom{
    @PersistenceContext
    EntityManager em;

    public UserRepositoryCustomImpl(EntityManager em) {
        super(User.class, em);
    }

    @Override
    public User findByUser(String userId) {
        Query query = em.createNativeQuery("SELECT u.* FROM core_user as u " +
                "WHERE u.id = ?", User.class);
        query.setParameter(1,userId);
        return (User) query.getSingleResult();
    }
}
