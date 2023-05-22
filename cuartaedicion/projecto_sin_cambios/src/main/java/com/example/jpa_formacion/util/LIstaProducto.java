package com.example.jpa_formacion.util;

import com.example.jpa_formacion.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class LIstaProducto {
    private List<Producto>  productoList;

    public LIstaProducto() {
        this.productoList = new ArrayList<>();
    }

    public void addLIstaProducto(Producto producto) {
        if (producto == null) {
            productoList.add(new Producto());
        } else
            productoList.add(producto);
    }
    public Integer count(){
        return productoList.size();
    }
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
}
