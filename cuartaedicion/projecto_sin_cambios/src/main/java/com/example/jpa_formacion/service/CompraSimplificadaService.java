package com.example.jpa_formacion.service;



import com.example.jpa_formacion.model.CompraSimplificada;
import com.example.jpa_formacion.model.GaleriaEmbeddable;
import com.example.jpa_formacion.repository.CompraSimplificadaRepository;
import com.example.jpa_formacion.repository.GaleriaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class CompraSimplificadaService extends AbstractBusinessServiceSoloEnt<CompraSimplificada,Integer,
        CompraSimplificadaRepository>  {
    //Acceso a los datos de la bbdd


    public CompraSimplificadaService(CompraSimplificadaRepository repo) {
        super(repo);
    }

}
