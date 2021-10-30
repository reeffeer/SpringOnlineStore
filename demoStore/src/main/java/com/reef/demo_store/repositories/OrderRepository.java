package com.reef.demo_store.repositories;

import com.reef.demo_store.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOwnerUsername(String ownerUsername);
}
