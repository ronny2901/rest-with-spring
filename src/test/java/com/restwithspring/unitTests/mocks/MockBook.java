package com.restwithspring.unitTests.mocks;

import com.restwithspring.data.BookVO;
import com.restwithspring.models.BookEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public BookEntity mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<BookEntity> mockEntityList() {
        List<BookEntity> books = new ArrayList<BookEntity>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    public BookEntity mockEntity(Integer number) {
        BookEntity book = new BookEntity();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(new BigDecimal(25));
        book.setTitle("Some Title" + number);
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(new BigDecimal(25));
        book.setTitle("Some Title" + number);
        return book;
    }
}
