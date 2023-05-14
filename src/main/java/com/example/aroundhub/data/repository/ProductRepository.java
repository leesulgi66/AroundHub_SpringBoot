package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {   // Entity의 id값 = String

}
