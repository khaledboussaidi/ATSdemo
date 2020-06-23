package com.example.ATS.repository;

import com.example.ATS.model.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {

    List<Products> findAllByPrice(double price, Pageable pageable);
    Products findById(int id);
}
