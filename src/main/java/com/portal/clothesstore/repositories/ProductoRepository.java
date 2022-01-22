package com.portal.clothesstore.repositories;

import com.portal.clothesstore.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {

    @Query("SELECT pd FROM ProductoModel pd ORDER BY pd.interacciones DESC")
    List<ProductoModel> findTopProductos(Integer cantidad);
}
