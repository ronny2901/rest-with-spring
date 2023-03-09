package com.restwithspring.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="book")
public class BookEntity implements Serializable {

    private static final long serialVersionUUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="author", nullable = false, length = 180)
    private String author;

    @Column(name="launch_date", nullable = false)
    private Date launchDate;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name="title", nullable = false)
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookEntity() {
    }

    public BookEntity(Long id, String author, Date launchDate, BigDecimal price, String title) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author) && Objects.equals(launchDate, that.launchDate) && Objects.equals(price, that.price) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launchDate, price, title);
    }
}
