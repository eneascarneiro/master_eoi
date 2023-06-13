package com.app.gestionturnos.repository;

import com.app.gestionturnos.model.Empresa;
import com.app.gestionturnos.model.TipoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa,Long> {
}
