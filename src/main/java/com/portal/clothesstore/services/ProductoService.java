package com.portal.clothesstore.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.clothesstore.dto.ProductoRequest;
import com.portal.clothesstore.dto.ProductoResponse;
import com.portal.clothesstore.dto.TopProductosResponse;
import com.portal.clothesstore.models.ProductoModel;
import com.portal.clothesstore.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<ProductoModel> getProductos(){
        return (List<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel saveProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }


    public ProductoResponse saveProducto(String producto, List<MultipartFile> file){
        ProductoRequest productJson;
        ProductoResponse productoResponse = new ProductoResponse();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            productJson = objectMapper.readValue(producto, ProductoRequest.class);
            ProductoModel productoToSave = ProductoRequest.toModelCreate(productJson);

            byte[] img;
            if(file.size() == 1){
                img = file.get(0).getBytes();
                productoToSave.setImgFrontal(img);
            }
            else if(file.size() >= 2){
                img = file.get(0).getBytes();
                productoToSave.setImgFrontal(img);
                img = file.get(1).getBytes();
                productoToSave.setImgTrasera(img);
            }
            this.verificarDescuento(productoToSave);
            productoRepository.save(productoToSave);
            productoResponse = new ProductoResponse(productoToSave.getId(),productoToSave.getNombre(),
                    productoToSave.getDescripcion(), productoToSave.getPrecio(),productoToSave.getDescuento(), productoToSave.getPaisVenta());
        } catch (IOException e){
            System.out.printf("Error", e.toString());
        }
        return productoResponse;
    }

    public void verificarDescuento(ProductoModel producto){
        String pais = producto.getPaisVenta();
        if(pais.equalsIgnoreCase("Colombia") || pais.equalsIgnoreCase("Mexico")){
            if(producto.getDescuento() > 50) producto.setDescuento(50);
        }
        else if(pais.equalsIgnoreCase("Chile") || pais.equalsIgnoreCase("Peru")){
            if(producto.getDescuento() > 30) producto.setDescuento(30);
        }
    }

    public byte[] getImagenFrontal(Long idProducto){
        ProductoModel producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        return producto.getImgFrontal();
    }

    public byte[] getImagenTrasera(Long idProducto){
        ProductoModel producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        return producto.getImgTrasera();
    }

    public List<TopProductosResponse> findTopProductos(Integer cantidad){
        List <ProductoModel> topProductos = productoRepository.findTopProductos(cantidad);
        topProductos = topProductos.subList(0, cantidad);
        List<TopProductosResponse> productosToResponse = new ArrayList<>();
        for (ProductoModel p : topProductos){
            productosToResponse.add(new TopProductosResponse(p.getId(), p.getNombre(),p.getPrecio(),
                                                                p.getDescuento(),p.getImgFrontal(),
                                                                    p.getImgTrasera()));
        }
        return productosToResponse;
    }


    public ResponseEntity<?> deleteProducto(Long productoId) {

        ProductoModel producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        productoRepository.delete(producto);
        return ResponseEntity.ok().build();
    }
}
