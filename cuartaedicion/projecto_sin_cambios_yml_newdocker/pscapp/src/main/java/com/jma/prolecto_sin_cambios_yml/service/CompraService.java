package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.Compra;

import java.util.List;

public interface CompraService {

    public List<Compra> getAll();

    public Compra getById(Long idCompra);

    public Compra save(Compra compra);
}
