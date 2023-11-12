package com.scribbledtech.router.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scribbledtech.router.service.OkHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/v1/router")
public class RequestRouterController {
    @Autowired
    private OkHttpService externalService;

    @RequestMapping("/product/list/")
    ResponseEntity<Object> getProductList(@RequestParam(name = "noOfProducts", required = false, defaultValue = "10") Integer noOfProducts) {

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(IntStream.rangeClosed(1, noOfProducts)
                        .mapToObj(this::getProduct)
                        .collect(Collectors.toList()));
    }

    public Map<String, Object> getProduct(Integer id) {
        String url = "http://localhost:8081/v1/product/" + id;
        String responseString = "Unknown";
        try {
            responseString = externalService.callExternalService(url);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseString, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
