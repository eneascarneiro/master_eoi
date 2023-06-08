package com.example.jpa_formacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class TablaIzqTablaDerKey implements Serializable {
    @Column(name = "tabladerId")
    Long tabladerId;

    @Column(name = "tablaizqId")
    Long tablaizqId;

    // hashcode and equals are necessary
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablaIzqTablaDerKey that = (TablaIzqTablaDerKey) o;
        return Objects.equals(tabladerId, that.tabladerId) &&
                Objects.equals(tablaizqId, that.tablaizqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tabladerId, tablaizqId);
    }
}
