package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductoEntity;

public interface ProductoService {
    List<ProductoEntity> buscarProductosElectronicos();
    ProductoEntity buscarProductoPorCodigo(String codigoProducto);
    double calcularTotalCarrito();
}