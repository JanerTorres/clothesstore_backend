package com.portal.clothesstore.dto;

public class TopProductosResponse {

    private Long id;
    private String nombre;
    private Integer precio;
    private Integer precioDescuento;
    private Integer descuento;
    private byte[] imgFrontal;
    private byte[] imgTrasera;

    public TopProductosResponse(Long id, String nombre, Integer precio, Integer descuento, byte[] imgFrontal, byte[] imgTrasera) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.precioDescuento = precio - (precio * (descuento/100));
        this.descuento = descuento;
        this.imgFrontal = imgFrontal;
        this.imgTrasera = imgTrasera;
    }

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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(Integer precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public byte[] getImgFrontal() {
        return imgFrontal;
    }

    public void setImgFrontal(byte[] imgFrontal) {
        this.imgFrontal = imgFrontal;
    }

    public byte[] getImgTrasera() {
        return imgTrasera;
    }

    public void setImgTrasera(byte[] imgTrasera) {
        this.imgTrasera = imgTrasera;
    }
}
