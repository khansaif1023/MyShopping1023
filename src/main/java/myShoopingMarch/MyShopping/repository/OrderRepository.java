package myShoopingMarch.MyShopping.repository;

import myShoopingMarch.MyShopping.models.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface OrderRepository extends JpaRepository<OrderTable, UUID> {
}
