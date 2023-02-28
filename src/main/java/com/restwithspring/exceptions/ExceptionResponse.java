package com.restwithspring.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse implements Serializable {

    private static final long serialVersionUUID = 1L;
    private Date timestamp;
    private String messagem;
    private String details;

    public ExceptionResponse(Date timestamp, String messagem, String details) {
        this.timestamp = timestamp;
        this.messagem = messagem;
        this.details = details;
    }
}
