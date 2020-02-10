package org.mak.sample.springdata.jpa.generic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID extends Serializable> {
    List<T> findAll();

//    @DefaultFilter
    List<T> getAll();

    Page<T> findAll(Pageable pageable);

    T save(T entity);

    <S extends T> List<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    void delete(T entity);

    void deleteById(ID id);

    long count();
}
