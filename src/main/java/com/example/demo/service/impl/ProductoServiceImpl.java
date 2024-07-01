	package com.example.demo.service.impl;
	
	import java.util.List;
	
	import javax.transaction.Transactional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.example.demo.entity.ProductoEntity;
	import com.example.demo.repository.ProductoRepository;
	import com.example.demo.service.ProductoService;
	
	
	
	@Service
	public class ProductoServiceImpl implements ProductoService {

	    @Autowired
	    private ProductoRepository productoRepository;

	    @Override
	    public List<ProductoEntity> buscarProductosElectronicos() {
	        return productoRepository.findAll();
	    }

	    @Override
	    public ProductoEntity buscarProductoPorCodigo(String codigoProducto) {
	        return productoRepository.findByCodigoProducto(codigoProducto);
	    }

	    @Override
	    public double calcularTotalCarrito() {
	        // Aquí deberías implementar la lógica para calcular el total del carrito
	        // Esto podría involucrar la suma de precios de productos en el carrito, por ejemplo
	        // Pero dado que no tienes un carrito explícito en el código proporcionado, adaptarías esto según tu estructura de carrito.
	        return 0.0; // Por ahora devuelve un valor estático, pero deberías calcular dinámicamente.
	    }
	}