package com.myapp.crudtemplate.controller;

import com.myapp.crudtemplate.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T, D, ID> {
    //TODO --- pagination
    protected abstract BaseService<T, D, ID> getService();

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        D created = getService().create(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<D> getAll() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        D dto = getService().getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
        D updated = getService().update((Long) id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete((Long) id);
        return ResponseEntity.noContent().build();
    }
}

