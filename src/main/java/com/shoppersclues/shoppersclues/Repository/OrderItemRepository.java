package com.shoppersclues.shoppersclues.Repository;

import com.shoppersclues.shoppersclues.Entity.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
