package com.shoppersclues.shoppersclues.Feign;


import com.shoppersclues.shoppersclues.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("VENDOR-SERVICE")
public interface Category {

    @GetMapping("/product/list")
    public List<ProductDTO> getAll();

    @GetMapping("/product/{category}")
    public List<ProductDTO> getByCategory(@PathVariable String category);

}
