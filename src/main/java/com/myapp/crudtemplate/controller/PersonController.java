package com.myapp.crudtemplate.controller;

import com.myapp.crudtemplate.dto.PersonDTO;
import com.myapp.crudtemplate.entity.Person;
import com.myapp.crudtemplate.service.BaseService;
import com.myapp.crudtemplate.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController extends BaseController<Person, PersonDTO, Long>{

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @Override
    protected BaseService<Person, PersonDTO, Long> getService() {
        return personService;
    }
}