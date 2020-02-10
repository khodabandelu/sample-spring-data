package org.mak.sample.springdata.jpa.generic.repository.security;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.repository.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryCustomImpl extends GenericRepositoryImpl<User, String> implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;

//    @Autowired
//    UserRepository userRepository;

    public UserRepositoryCustomImpl(EntityManager em) {
        super(User.class, em);
    }

    @Override
    public User findByUser(String username) {
        Query query = em.createNativeQuery("SELECT u.* FROM core_user as u " +
                "WHERE u.username like ?", User.class);
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }

   /* @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }*/

}
