package com.scribbledtech.rest_product_service.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping("/{productId}")
    Map<String, Object> getProductInfo(@PathVariable(name = "productId") Integer productId) {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Product "+productId);
        response.put("description", "Description "+productId);
        response.put("price", productId);
        response.put("quantity", productId);
        return response;
    }
}
