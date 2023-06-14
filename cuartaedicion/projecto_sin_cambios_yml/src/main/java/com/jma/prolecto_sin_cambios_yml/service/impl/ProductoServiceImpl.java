package com.jma.prolecto_sin_cambios_yml.service.impl;

import com.jma.prolecto_sin_cambios_yml.model.Producto;
import com.jma.prolecto_sin_cambios_yml.repository.ProductoRepository;
import com.jma.prolecto_sin_cambios_yml.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoDao;

    @Override
    public List<Producto> getAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto getById(Long idProducto) {
        Optional<Producto> productoOptional = productoDao.findById(idProducto);
        Producto productovacio = new Producto();
        if (((Optional<?>) productoOptional).isPresent())
            return  productoOptional.get();
        else
            return productovacio;
    }

    @Override
    @Transactional(readOnly = false)
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = false)
    public Producto update(Producto producto) {
        return productoDao.saveAndFlush(producto);
    }

    @Override
    public void updateStock(Long idProducto, Long cantidad) {
        Producto producto = this.getById(idProducto);
        producto.setCantidad(producto.getCantidad() - cantidad);
        this.update(producto);
    }
}
