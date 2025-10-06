package com.shoppersclues.shoppersclues.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDTO {
    private UUID productId;
    private int quantity;
    private double price;
    private double subTotal;
}
