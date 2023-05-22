package com.example.jpa_formacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GaleriaEtiquetaKey implements Serializable {
    @Column(name = "galeriaEmbedId")
    Long galeriaEmbedId;

    @Column(name = "etiquetaEmbedId")
    Long etiquetaEmbedId;

    // hashcode and equals are necessary
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GaleriaEtiquetaKey that = (GaleriaEtiquetaKey) o;
        return Objects.equals(galeriaEmbedId, that.galeriaEmbedId) &&
                Objects.equals(etiquetaEmbedId, that.etiquetaEmbedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(galeriaEmbedId, etiquetaEmbedId);
    }
}
