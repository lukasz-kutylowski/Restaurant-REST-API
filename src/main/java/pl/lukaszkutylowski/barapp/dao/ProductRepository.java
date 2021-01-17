package pl.lukaszkutylowski.barapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszkutylowski.barapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
