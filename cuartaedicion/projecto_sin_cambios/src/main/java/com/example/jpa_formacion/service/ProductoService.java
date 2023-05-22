package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getAll();

    public Producto getById(Long idProducto);

    public Producto save(Producto producto);

    public Producto update(Producto producto);

    public void updateStock(Long idProducto, Long cantidad);
}
