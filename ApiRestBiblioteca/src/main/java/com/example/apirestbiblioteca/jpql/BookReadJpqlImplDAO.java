package com.example.apirestbiblioteca.jpql;

import com.example.apirestbiblioteca.dao.GenericDAOImpl;
import com.example.apirestbiblioteca.dto.Informe2CamposDTO;
import com.example.apirestbiblioteca.dto.Informe7CamposDTO;
import com.example.apirestbiblioteca.entity.Books;
import com.example.apirestbiblioteca.entity.BooksRead;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;



public class BookReadJpqlImplDAO extends GenericDAOImpl<Books, Long> implements BooksReadJpqlDAO {
    private static final DateTimeFormatter DATE_FORMATER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public BookReadJpqlImplDAO() {
        super(Books.class);
    }

    public  List<Informe2CamposDTO> getSummaryReadSold() {
        return em.createNamedQuery("Books.lista", Object[].class)
                .getResultStream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private Informe2CamposDTO map(Object[] columns) {
        return new Informe2CamposDTO(
                columns[0].toString(),
                columns[1].toString());
    }

}
