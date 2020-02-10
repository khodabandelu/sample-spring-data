package org.mak.sample.springdata.jpa.generic.repository.specification;

import org.mak.sample.springdata.jpa.generic.domain.security.User;
import org.mak.sample.springdata.jpa.generic.domain.security.User_;
import org.mak.sample.springdata.jpa.generic.dto.security.UserSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecifications extends BaseSpecification<User, UserSearch> {

    public static Specification<User> UserIncludeUsername(String username) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(User_.username), "%" + username + "%");
        };
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

   /* @Override
    public Specification<User> getFilter(UserSearch request) {
        return (root, query, cb) -> {
            query.distinct(true); //Important because of the join in the addressAttribute specifications
            return where(
                    where(firstNameContains(request.getSearch()))
                            .or(lastNameContains(request.getSearch()))
                            .or(emailContains(request.getSearch()))
            )
                    .and(streetContains(request.street))
                    .and(cityContains(request.city))
                    .toPredicate(root, query, cb);
        };

    }

    private Specification<User> firstNameContains(String firstName) {
        return userAttributeContains("firstName", firstName);
    }

    private Specification<User> lastNameContains(String lastName) {
        return userAttributeContains("lastName", lastName);
    }

    private Specification<User> emailContains(String email) {
        return userAttributeContains("email", email);
    }

    private Specification<User> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }

    private Specification<User> cityContains(String city) {
        return addressAttributeContains("city", city);
    }

    private Specification<User> streetContains(String street) {
        return addressAttributeContains("street", street);
    }

    private Specification<User> addressAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            ListJoin<User, Address> addresses = root.joinList("addresses", JoinType.INNER);

            return cb.like(
                    cb.lower(addresses.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }*/
}
