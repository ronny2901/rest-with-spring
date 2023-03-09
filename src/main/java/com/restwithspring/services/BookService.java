package com.restwithspring.services;

import com.restwithspring.data.BookVO;
import com.restwithspring.exceptions.RequiredObjectIsNullException;
import com.restwithspring.exceptions.ResourceNotFoundException;
import com.restwithspring.mapper.ModelMapperConverter;
import com.restwithspring.models.BookEntity;
import com.restwithspring.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BookService {
    ModelMapperConverter converter;
    @Autowired
    BookRepository repository;

    public List<BookVO> findAll() {

        log.info("Finding all book!");

        return converter.parseListObjects(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {

        log.info("Finding one book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return converter.parseObject(entity, BookVO.class);
    }

    public BookVO create(BookVO book) {

        if (book == null) throw new RequiredObjectIsNullException();

        log.info("Creating one book!");
        var entity = converter.parseObject(book, BookEntity.class);
        return converter.parseObject(repository.save(entity), BookVO.class);
    }

    public BookVO update(BookVO book) {

        if (book == null) throw new RequiredObjectIsNullException();

        log.info("Updating one book!");

        var entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return converter.parseObject(repository.save(entity), BookVO.class);
    }

    public void delete(Long id) {

        log.info("Deleting one book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
