package com.myapp.crudtemplate.service;

import com.myapp.crudtemplate.dto.PersonDTO;
import com.myapp.crudtemplate.entity.Person;
import com.myapp.crudtemplate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Map Person entity to PersonDTO
    public PersonDTO mapToDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .username(person.getUsername())
                .email(person.getEmail())
                .mobile(person.getMobile())
                .address(person.getAddress())
                .build();
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        Person person = Person.builder()
                .username(personDTO.getUsername())
                .email(personDTO.getEmail())
                .mobile(personDTO.getMobile())
                .address(personDTO.getAddress())
                .build();

        // Save entity and return the saved instance as DTO
        Person savedPerson = personRepository.save(person);
        return mapToDTO(savedPerson);
    }

    @Override
    public List<PersonDTO> getAll() {
        return personRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return mapToDTO(person);
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        person.setUsername(personDTO.getUsername());
        person.setEmail(personDTO.getEmail());
        person.setMobile(personDTO.getMobile());
        person.setAddress(personDTO.getAddress());

        // Update the entity and map it back to a DTO
        Person updatedPerson = personRepository.save(person);
        return mapToDTO(updatedPerson);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

}