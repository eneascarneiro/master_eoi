package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.EtiquetaDtoApi;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.repository.EtiquetaRepository;
import com.example.jpa_formacion.service.mapper.EtiquetaMapper;
import com.example.jpa_formacion.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class EtiquetaService extends AbstractBusinessService<Etiqueta,Integer, EtiquetaDto,
        EtiquetaRepository, EtiquetaMapper>  {
    //Acceso a los datos de la bbdd


    public EtiquetaService(EtiquetaRepository repo, EtiquetaMapper serviceMapper) {
        super(repo, serviceMapper);
    }


    public List<EtiquetaDtoApi> buscartodosapi(){
        return  this.serviceMapper.toDtoApi(this.getRepo().findAll());
    }

    public EtiquetaDtoApi buscarunoapi(Integer id) throws ResourceNotFoundException {
        //Buscar la entidad
        Optional<Etiqueta> etiqueta = this.getRepo().findById(id);
        //Controlamos si hemos encontrado o no
        if (etiqueta.isPresent()) {
            //Convertir la Etiqueta a EtiquetaDtoApi
            EtiquetaDtoApi etiquetaDtoApi = this.serviceMapper.toDtoApiEnt(etiqueta.get());
            return  etiquetaDtoApi;
        } else {
            throw new ResourceNotFoundException("Etiqueta no encontrada");
        }

    }

    public EtiquetaDtoApi buscarunoapi2(Integer id) throws ResourceNotFoundException {
        //Opcion 2
        Etiqueta etiqueta1 = this.getRepo().findById(id).orElseThrow(() -> new ResourceNotFoundException("Etiqueta no encontrada"));
        //Convertir la Etiqueta a EtiquetaDtoApi
        EtiquetaDtoApi etiquetaDtoApi = this.serviceMapper.toDtoApiEnt(etiqueta1);
        return  etiquetaDtoApi;
    }

    public EtiquetaDtoApi guardarApiuno(Etiqueta etiqueta)  {
        //Opcion 2
        Etiqueta etiqueta1 = this.getRepo().save(etiqueta);
        //Convertir la Etiqueta a EtiquetaDtoApi
        EtiquetaDtoApi etiquetaDtoApi = this.serviceMapper.toDtoApiEnt(etiqueta1);
        return  etiquetaDtoApi;
    }
}
