package org.mak.sample.springdata.jpa.generic.repository.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T, U> implements Specification<T> {

    private final String wildcard = "%";

   /* public abstract Specification<T> getFilter(U request);

    protected String containsLowerCase(String searchField) {
        return wildcard + searchField.toLowerCase() + wildcard;
    }*/
}