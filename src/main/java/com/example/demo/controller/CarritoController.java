package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Añade la importación correcta para Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.service.ProductoService;

@Controller // Asegúrate de que el controlador esté anotado correctamente
public class CarritoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<ProductoEntity> productos = productoService.buscarProductosElectronicos();
        model.addAttribute("productos", productos);
        return "Carrito"; // Devuelve la vista correcta
    }
    
    @GetMapping("/carrito")
    public String mostrarCarrito(Model model) {
        List<ProductoEntity> productos = productoService.buscarProductosElectronicos();
        double total = productoService.calcularTotalCarrito(); // Calcula el total del carrito
        model.addAttribute("productos", productos);
        model.addAttribute("total", total); // Agrega el total al modelo
        return "carrito"; // Devuelve la vista correcta
    }
}
