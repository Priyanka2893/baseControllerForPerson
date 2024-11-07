package com.myapp.crudtemplate.service;

import com.myapp.crudtemplate.dto.PersonDTO;
import com.myapp.crudtemplate.entity.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, PersonDTO, Long>{
    public PersonDTO mapToDTO(Person person);
}