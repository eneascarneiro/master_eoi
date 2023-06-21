package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getAll();

    public Producto getById(Long idProducto);

    public Producto save(Producto producto);

    public Producto update(Producto producto);

    public void updateStock(Long idProducto, Long cantidad);
}
