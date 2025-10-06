package com.shoppersclues.shoppersclues.Controller;

import com.shoppersclues.shoppersclues.DTO.OrderDTO;
import com.shoppersclues.shoppersclues.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public OrderDTO placeOrder(@RequestBody Map<UUID, Integer> productQuantities) {
        return orderService.placeOrder(productQuantities);
    }
}

