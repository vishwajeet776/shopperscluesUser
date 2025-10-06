package com.shoppersclues.shoppersclues.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "SHOPPERSCLUESINVENTORY")
public interface InventoryClient {
    @GetMapping("/inventory/check")
    boolean checkAvailability(@RequestParam("productId") UUID productId,
                              @RequestParam("qty") int qty);

    // Update quantity for a specific product
    @PutMapping("/inventory/update/{productId}")
    void updateQuantity(@PathVariable("productId") UUID productId,
                        @RequestParam("quantity") Long quantity);
}
