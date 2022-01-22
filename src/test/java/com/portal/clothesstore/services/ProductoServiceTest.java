package com.portal.clothesstore.services;

import com.portal.clothesstore.dto.ProductoResponse;
import com.portal.clothesstore.models.ProductoModel;
import com.portal.clothesstore.repositories.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private ProductoModel producto;
    private ProductoResponse productoR;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        producto = new ProductoModel();
        producto.setDescuento(20);
        producto.setNombre("Camisa");
        producto.setId(1L);
        producto.setInteracciones(1);
        producto.setPaisVenta("Colombia");
        producto.setDescripcion("Descripcion");

    }

    @Test
    void saveProducto() {
        when(productoService.saveProducto(any(ProductoModel.class))).thenReturn(producto);
        assertNotNull(productoService.saveProducto(new ProductoModel()));
    }

    @Test
    void verificarDescuento() {
    }

    @Test
    void getProductos(){
        when(productoService.getProductos()).thenReturn(Arrays.asList(producto));
        assertNotNull(productoService.getProductos());
    }

}