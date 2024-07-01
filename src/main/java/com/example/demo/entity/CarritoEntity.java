package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_carrito")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarritoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "stock", nullable = false)
    private Integer stock;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "url_Imagen", nullable = false)
    private String urlImagen;
    
    @Column(name = "calcular_TotalCarrito", nullable = false)
    private Double calcularTotalCarrito;
    
   
    
    
    
    
    
}







