package com.shoppersclues.shoppersclues.Controller;

import com.shoppersclues.shoppersclues.Entity.ProductDTO;
import com.shoppersclues.shoppersclues.Feign.Catalog;
import org.springframework.cloud.openfeign.FeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
//@RequiredArgsConstructor
public class CatalogController {

    @Autowired
    private Catalog catalog; // FeignClient interface

    @GetMapping("/products")
    public List<ProductDTO> fetchProducts() {
        return catalog.getAll(); // calling vendor-service via Eureka
    }
}
