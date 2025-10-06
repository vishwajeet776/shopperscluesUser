package com.shoppersclues.shoppersclues.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID productId;
    private int quantity;
    private double price;    // unit price
    private double subTotal; // price * quantity

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
