package com.shoppersclues.shoppersclues.Repository;

import com.shoppersclues.shoppersclues.Entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
