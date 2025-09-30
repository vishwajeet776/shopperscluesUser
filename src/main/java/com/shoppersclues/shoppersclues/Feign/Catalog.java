package com.shoppersclues.shoppersclues.Feign;


import com.shoppersclues.shoppersclues.Entity.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("VENDOR-SERVICE")
public interface Catalog {

    @GetMapping("/product/list")
    public List<ProductDTO> getAll();


}
