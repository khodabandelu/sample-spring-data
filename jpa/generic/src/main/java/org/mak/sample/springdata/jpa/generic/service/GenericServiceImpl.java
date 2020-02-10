package org.mak.sample.springdata.jpa.generic.service;

import org.mak.sample.springdata.jpa.generic.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    protected abstract GenericRepository<T, ID> getGenericRepository();

    public List<T> findAll() {
        return getGenericRepository().findAll("fjeihfiuehgifheh");
    }

    @Override
    public List<T> getAll() {
        return getGenericRepository().findAll();
    }

    public Page<T> findAll(Pageable searchOption) {
        return getGenericRepository().findAll(searchOption);
    }

    public Optional<T> findById(ID entityId) {
        return getGenericRepository().findById(entityId);
    }

    @Transactional
    public void delete(T entity) {
        getGenericRepository().delete(entity);
    }

    @Transactional
    public void deleteById(ID entityId) {
        getGenericRepository().deleteById(entityId);
    }

    public long count() {
        return getGenericRepository().count();
    }

    @Transactional
    public T save(T entity) {
        return getGenericRepository().save(entity);
    }

    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return getGenericRepository().saveAll(entities);
    }

}
