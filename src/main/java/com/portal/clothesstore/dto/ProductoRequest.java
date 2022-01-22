package com.portal.clothesstore.dto;

import com.portal.clothesstore.models.ProductoModel;
import lombok.*;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductoRequest {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer descuento;
    private String paisVenta;


    public static ProductoModel toModelCreate(ProductoRequest productoToCreate){
        return ProductoModel.builder()
                .nombre(productoToCreate.getNombre())
                .descripcion(productoToCreate.getDescripcion())
                .precio(productoToCreate.getPrecio())
                .descuento(productoToCreate.getDescuento())
                .paisVenta(productoToCreate.getPaisVenta())
                .interacciones(0).build();
    }

    public static ProductoModel toModelUpdate(ProductoModel productoToUpdate){
        return ProductoModel.builder()
                .id(productoToUpdate.getId())
                .nombre(productoToUpdate.getNombre())
                .descripcion(productoToUpdate.getDescripcion())
                .precio(productoToUpdate.getPrecio())
                .descuento(productoToUpdate.getDescuento())
                .paisVenta(productoToUpdate.getPaisVenta()).build();
    }

}
