package pl.lukaszkutylowski.barapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszkutylowski.barapp.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
