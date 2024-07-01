package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProductoRepository;

@Controller
public class ProductosElectronicosController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<ProductoEntity> listaProductos = productoRepository.findAll();
        model.addAttribute("lst_productos", listaProductos);
        return "Home";
    }

    @GetMapping("/registrar")
    public String createProductoForm(Model model) {
        List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("lst_categorias", listaCategorias);
        model.addAttribute("producto", new ProductoEntity());
        return "Registrar"; // Nombre del archivo HTML para registrar productos
    }

    @PostMapping("/registrar")
    public String createProducto(@ModelAttribute ProductoEntity producto, Model model) {
        try {
            if (productoRepository.findByCodigoProducto(producto.getCodigoProducto()) != null) {
                model.addAttribute("errorMessage", "El producto con este código ya existe");
                List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
                model.addAttribute("lst_categorias", listaCategorias);
                return "Registrar";
            }
            productoRepository.save(producto);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Error al guardar el producto: El producto con este código ya existe");
            List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
            model.addAttribute("lst_categorias", listaCategorias);
            return "Registrar";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al guardar el producto: " + e.getMessage());
            List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
            model.addAttribute("lst_categorias", listaCategorias);
            return "Registrar";
        }
    }

    @GetMapping("/actualizar/{id}")
    public String updateForm(Model model, @PathVariable("id") String id) {
        ProductoEntity producto = productoRepository.findById(id).orElse(null);
        if (producto == null) {
            return "redirect:/";
        }
        List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("lst_categorias", listaCategorias);
        model.addAttribute("producto", producto);
        return "Actualizar";
    }

    @PostMapping("/actualizar")
    public String updateProducto(@ModelAttribute ProductoEntity producto) {
        productoRepository.save(producto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable("id") String id) {
        productoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/producto")
    public String buscarProductoPorCodigo(@RequestParam("id") String codigoBuscado, Model model) {
        ProductoEntity producto = productoRepository.findByCodigoProducto(codigoBuscado);
        if (producto != null) {
            model.addAttribute("lst_productos", List.of(producto));
            model.addAttribute("codigoBuscado", codigoBuscado);
        } else {
            model.addAttribute("errorMessage", "Producto no encontrado con código: " + codigoBuscado);
            model.addAttribute("lst_productos", productoRepository.findAll());
        }
        return "Home";
    }
}