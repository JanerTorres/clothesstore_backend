package com.portal.clothesstore.models;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "descuento")
    private Integer descuento;

    @Column(name = "pais_venta", length = 30)
    private String paisVenta;

    @Column(name = "interacciones")
    private Integer interacciones;

    @Lob
    @Column(name="img_frontal")
    private byte[] imgFrontal;

    @Lob
    @Column(name="img_trasera")
    private byte[] imgTrasera;


}
