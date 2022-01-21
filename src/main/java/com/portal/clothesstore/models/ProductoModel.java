package com.portal.clothesstore.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer descuento;
    private String paisVenta;
    //private List<String> imagenes;




}
