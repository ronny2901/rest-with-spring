package com.restwithspring.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class BookVO {

    private Long id;
    @JsonProperty("author")
    private String author;
    @JsonProperty("launch_date")
    private Date launchDate;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("title")
    private String title;

    public BookVO() {
    }

    public BookVO(Long id, String author, Date launchDate, BigDecimal price, String title) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

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
}
