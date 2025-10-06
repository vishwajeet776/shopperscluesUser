package com.shoppersclues.shoppersclues.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {
    private Long id;
    private double totalPrice;
    private String status;
    private LocalDateTime orderTime;
    private List<OrderItemDTO> items;
}



