package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformeBooksReadSoldDTO {
    private Integer id;
    private String fechaLectura;
    private Integer booksId;
    private Integer userId;
    private String booksTitle;
    private String  fechaVenta;
    private float precio;


}
