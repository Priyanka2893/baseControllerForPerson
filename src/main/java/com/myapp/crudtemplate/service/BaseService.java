package com.myapp.crudtemplate.service;
import java.util.List;

public interface BaseService<T, D, ID> {
    D create(D dto);
    List<D> getAll();
    D getById(ID id);
    D update(Long id, D dto);
    void delete(Long id);
}

