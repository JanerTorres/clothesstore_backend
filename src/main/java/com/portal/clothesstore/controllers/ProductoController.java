package com.portal.clothesstore.controllers;

import com.portal.clothesstore.dto.ProductoResponse;
import com.portal.clothesstore.models.ProductoModel;
import com.portal.clothesstore.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {


    @Autowired
    ProductoService productoService;

    @GetMapping
    public List<ProductoModel> getProductos(){
        return productoService.getProductos();
    }

    @PostMapping
    public ProductoModel saveProducto(@RequestBody ProductoModel producto){
        return this.productoService.saveProducto(producto);
    }

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE,
                                                 MediaType.MULTIPART_FORM_DATA_VALUE})
    public ProductoResponse crearProducto(@RequestPart("product") String producto, @RequestPart("file") List<MultipartFile> file){
        ProductoResponse productoJson = productoService.saveProducto(producto, file);
        return productoJson;
    }

    @RequestMapping(value = "/img-frontal", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImagenFrontal(@RequestParam(value = "id") Long idProducto){
        return productoService.getImagenFrontal(idProducto);
    }

    @RequestMapping(value = "/img-trasera", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImagenTrasera(@RequestParam(value = "id") Long idProducto){
        return productoService.getImagenTrasera(idProducto);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable(value = "id") Long idProducto) {
        return productoService.deleteProducto(idProducto);
    }



}
