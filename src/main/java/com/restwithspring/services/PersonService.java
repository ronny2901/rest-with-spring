package com.restwithspring.services;

import com.restwithspring.data.PersonVO;
import com.restwithspring.exceptions.RequiredObjectIsNullException;
import com.restwithspring.exceptions.ResourceNotFoundException;
import com.restwithspring.mapper.ModelMapperConverter;
import com.restwithspring.models.PersonEntity;
import com.restwithspring.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonService {
    
    ModelMapperConverter converter;

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {

        log.info("Finding all people!");

        return converter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        log.info("Finding one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return converter.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        if (person == null) throw new RequiredObjectIsNullException();

        log.info("Creating one person!");
        var entity = converter.parseObject(person, PersonEntity.class);
        return converter.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {

        if (person == null) throw new RequiredObjectIsNullException();

        log.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return  converter.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {

        log.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
