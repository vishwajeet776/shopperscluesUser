package com.shoppersclues.shoppersclues.Service;

import com.shoppersclues.shoppersclues.DTO.OrderDTO;
import com.shoppersclues.shoppersclues.DTO.OrderItemDTO;
import com.shoppersclues.shoppersclues.DTO.ProductDTO;
import com.shoppersclues.shoppersclues.Entity.Order;
import com.shoppersclues.shoppersclues.Entity.OrderItem;
import com.shoppersclues.shoppersclues.Feign.InventoryClient;
import com.shoppersclues.shoppersclues.Feign.ProductClient;
import com.shoppersclues.shoppersclues.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductClient productClient;
    private final InventoryClient inventoryClient;

    public OrderDTO placeOrder(Map<UUID, Integer> productQuantities) {
        Order order = new Order();
        order.setStatus("PLACED");
        order.setOrderTime(LocalDateTime.now());

        double totalPrice = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (Map.Entry<UUID, Integer> entry : productQuantities.entrySet()) {
            UUID productId = entry.getKey();
            Long qty = Long.valueOf(entry.getValue());

            // 1. Get product
            ProductDTO product = productClient.getById(productId);

            // 2. Check inventory
            boolean available = inventoryClient.checkAvailability(productId, Math.toIntExact(qty));
            if (!available) {
                throw new RuntimeException("Stock not available for " + product.getName());
            }

            // 3. Update inventory
            inventoryClient.updateQuantity(productId, -qty);

            // 4. Create OrderItem
            OrderItem item = new OrderItem();
            item.setProductId(productId);
            item.setQuantity(Math.toIntExact(qty));
            item.setPrice(product.getPrice());
            item.setSubTotal(product.getPrice() * qty);
            item.setOrder(order);

            totalPrice += item.getSubTotal();
            orderItems.add(item);
        }

        order.setTotalPrice(totalPrice);
        order.setItems(orderItems);

        Order saved = orderRepo.save(order);

        return toDTO(saved);
    }

    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        dto.setOrderTime(order.getOrderTime());

        List<OrderItemDTO> items = order.getItems().stream()
                .map(item -> {
                    OrderItemDTO i = new OrderItemDTO();
                    i.setProductId(item.getProductId());
                    i.setQuantity(item.getQuantity());
                    i.setPrice(item.getPrice());
                    i.setSubTotal(item.getSubTotal());
                    return i;
                }).toList();

        dto.setItems(items);
        return dto;
    }
}
