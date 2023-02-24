package com.example.demo.data.jpql;



import com.example.demo.data.dao.GenericDAOImpl;
import com.example.demo.data.entity.BooksRead;
import com.example.demo.dto.Informe7CamposDTO;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class BookReadJpqlImplDAO extends GenericDAOImpl<BooksRead, Long> implements BooksReadJpqlDAO {
    private static final DateTimeFormatter DATE_FORMATER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public BookReadJpqlImplDAO() {
        super(BooksRead.class);
    }

    public  List<Informe7CamposDTO> getSummaryReadSold() {
        return em.createNamedQuery("BooksRead.compras", Object[].class)
                .getResultStream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private Informe7CamposDTO map(Object[] columns) {
        return new Informe7CamposDTO(
                columns[0].toString(),
                columns[1].toString(),
                columns[2].toString(),
                columns[3].toString(),
                columns[4].toString(),
                columns[5].toString(),
                columns[6].toString());
    }

}
