package com.app.gestionturnos.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityScan
@Table(name = "TipoEmpresa")
public class TipoEmpresa {
    @Id
    @Column(name ="codigo_oficina")
    private long id;
    @Column (name ="descripcion",length = 30)
    private String descEmpresa	;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tipoEmpresas")
    private Set<Empresa> empresas;
}
