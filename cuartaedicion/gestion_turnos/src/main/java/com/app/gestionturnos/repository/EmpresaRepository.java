package com.app.gestionturnos.repository;

import com.app.gestionturnos.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
    Page<Empresa> findEmpresaByCiudadContainingIgnoreCase(String valor ,
                                                Pageable pageable);
    Page<Empresa> findEmpresaByPaisContainingIgnoreCase(String valor ,
                                              Pageable pageable);

    Page<Empresa> findEmpresaByRegionContainingIgnoreCase(String valor ,
                                                Pageable pageable);
    Page<Empresa> findEmpresaByCodigopostalContainingIgnoreCase(String valor ,
                                                       Pageable pageable);
    Page<Empresa> findEmpresaByTelefonoContainingIgnoreCase(String valor ,
                                                  Pageable pageable);

    Page<Empresa> findEmpresaByLineadireccion1ContainingIgnoreCase(String valor ,
                                                          Pageable pageable);

    Page<Empresa> findEmpresaByLineadireccion2ContainingIgnoreCase(String valor ,
                                                          Pageable pageable);

}
