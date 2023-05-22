package com.example.jpa_formacion.service.impl;

import com.example.jpa_formacion.model.Compra;
import com.example.jpa_formacion.model.DetalleCompra;
import com.example.jpa_formacion.model.Producto;
import com.example.jpa_formacion.repository.CompraRepository;
import com.example.jpa_formacion.repository.DetalleCompraRepository;
import com.example.jpa_formacion.service.CompraService;
import com.example.jpa_formacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository compraDao;

    @Autowired
    DetalleCompraRepository detalleCompraDao;

    @Autowired
    ProductoService productoService;

    @Override
    public List<Compra> getAll() {
        return compraDao.findAll();
    }

    @Override
    public Compra getById(Long idCompra) {
        Optional<Compra> compraOptional = compraDao.findById(idCompra);
        Compra compravacio = new Compra();
        if (((Optional<?>) compraOptional).isPresent())
            return  compraOptional.get();
        else
            return compravacio;
    }

    @Override
    @Transactional(readOnly = false)
    public Compra save(Compra compra) {

        compra.setFecha(new Date());

        // Calcular el total de los productos
        compra.setTotal(
                compra.getListaDetalleCompra()
                        .stream()
                        .mapToDouble(detalle -> {
                            // Calcula precio del producto * cantidad
                            Producto producto = productoService.getById(detalle.getProducto().getPk());
                            detalle.setPrecio(producto.getPrecio());
                            detalle.setTotal(producto.getPrecio() * detalle.getCantidad());

                            return detalle.getTotal();
                        })
                        .sum()
        );

        // Actualizar stock de cada producto
        compra.getListaDetalleCompra()
                .forEach(detalle -> productoService.updateStock(detalle.getProducto().getPk(), detalle.getCantidad()));

        compraDao.save(compra);

        compra.getListaDetalleCompra().forEach(detalleCompra -> {
            detalleCompra.setCompra(compra);
            detalleCompraDao.save(detalleCompra);
        });
        return compra;
    }
}
