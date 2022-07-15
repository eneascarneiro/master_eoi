package com.example.apirestbiblioteca.api;

import com.example.apirestbiblioteca.dto.Informe2CamposDTO;
import com.example.apirestbiblioteca.dto.Informe7CamposDTO;
import com.example.apirestbiblioteca.jpql.BookReadJpqlImplDAO;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/lista_libros")
public class lista_libros {
    @Inject
    BookReadJpqlImplDAO bookReadJpqlImplDAO;
    @GET
    @Produces("text/json")
    public String InformeLibros(){
        //Cargamos los valores en una lista
        final List<Informe2CamposDTO> all =  bookReadJpqlImplDAO.getSummaryReadSold();
        //Convertimos de una lista a un json
        String json = new Gson().toJson(all );
        return (json.toString());
    }
}
