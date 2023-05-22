package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.Compra;

import java.util.List;

public interface CompraService {

    public List<Compra> getAll();

    public Compra getById(Long idCompra);

    public Compra save(Compra compra);
}
