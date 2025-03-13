package org.example.Product.Repository;

import org.example.Product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositoryOrderService")
public interface ProductRepository extends JpaRepository<Product,Long> {
}
