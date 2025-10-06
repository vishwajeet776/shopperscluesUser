package com.shoppersclues.shoppersclues.Controller;

import com.shoppersclues.shoppersclues.DTO.ProductDTO;
import com.shoppersclues.shoppersclues.Feign.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
//@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private Category category; // FeignClient interface

    @GetMapping("/products")
    public List<ProductDTO> fetchProducts() {
        return category.getAll(); // calling vendor-service via Eureka
    }
    @GetMapping("/{categorys}")
    public List<ProductDTO> fetchByCategory(@PathVariable String categorys) {
        return category.getByCategory(categorys); // calling vendor-service via Eureka
    }

}
