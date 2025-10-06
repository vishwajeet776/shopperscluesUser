package com.shoppersclues.shoppersclues.Feign;

import com.shoppersclues.shoppersclues.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

//@FeignClient(name = "VENDOR-SERVICE")
//public interface ProductClient {
//    @GetMapping("/product/{id}")
//    public ProductDTO getById(@PathVariable UUID id);
//
//}

@FeignClient(name = "VENDOR-SERVICE")
public interface ProductClient {
    @GetMapping("/product/{id}")
    ProductDTO getById(@PathVariable("id") UUID id);
}

