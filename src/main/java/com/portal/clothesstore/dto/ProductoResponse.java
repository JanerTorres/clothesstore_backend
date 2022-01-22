package com.portal.clothesstore.dto;

import java.io.Serializable;

public class ProductoResponse implements Serializable {


    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer descuento;
    private String paisVenta;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public String getPaisVenta() {
        return paisVenta;
    }

    public void setPaisVenta(String paisVenta) {
        this.paisVenta = paisVenta;
    }

    public ProductoResponse(Long id, String nombre, String descripcion, Integer precio, Integer descuento, String paisVenta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.paisVenta = paisVenta;
    }

    public ProductoResponse() {
    }



}
