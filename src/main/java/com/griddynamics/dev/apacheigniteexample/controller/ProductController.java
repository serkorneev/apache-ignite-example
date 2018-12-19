package com.griddynamics.dev.apacheigniteexample.controller;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import com.griddynamics.dev.apacheigniteexample.exception.EntityNotFoundException;
import com.griddynamics.dev.apacheigniteexample.repository.ProductRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") @ApiParam("id") String id) {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new EntityNotFoundException("Entity not found");
        }
        return product;
    }
}
