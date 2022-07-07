package com.example.demo.data.jpql;

import com.example.demo.data.dao.GenericDAOImpl;
import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.BooksSold;
import com.example.demo.dto.InformeBooksReadSoldDTO;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.beans.JavaBean;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookReadJpqlImplDAO extends GenericDAOImpl<BooksRead, Long> implements BooksReadJpqlDAO {
    private static final DateTimeFormatter DATE_FORMATER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public BookReadJpqlImplDAO() {
        super(BooksRead.class);
    }

    public  List<InformeBooksReadSoldDTO> getSummaryReadSold() {
        return em.createNamedQuery("BooksRead.compras", Object[].class)
                .getResultStream()
                .map(this::map)
                .collect(Collectors.toList());
    }


    private InformeBooksReadSoldDTO map(Object[] columns) {
        return new InformeBooksReadSoldDTO(
                 Integer.parseInt(columns[0].toString()),
                columns[1].toString(),

                Integer.parseInt(columns[2].toString()),
                Integer.parseInt(columns[3].toString()),
                columns[4].toString(),
                columns[5].toString(),
                (float) columns[6]);

    }

}
