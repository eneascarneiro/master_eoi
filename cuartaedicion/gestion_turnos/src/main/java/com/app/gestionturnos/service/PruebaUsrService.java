package com.app.gestionturnos.service;

import com.app.gestionturnos.model.PruebaUsr;
import com.app.gestionturnos.repository.PruebaUsrRepository;
import org.springframework.stereotype.Service;


@Service
public class PruebaUsrService extends AbstractBusinessServiceSoloEnt<PruebaUsr,Long, PruebaUsrRepository>  {
    protected PruebaUsrService(PruebaUsrRepository pruebaUsrRepository) {
        super(pruebaUsrRepository);
    }





}
