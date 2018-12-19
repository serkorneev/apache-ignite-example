package com.griddynamics.dev.apacheigniteexample.controller;

import com.griddynamics.dev.apacheigniteexample.controller.dto.UpdateProductDTO;
import com.griddynamics.dev.apacheigniteexample.entity.Product;
import com.griddynamics.dev.apacheigniteexample.exception.EntityNotFoundException;
import com.griddynamics.dev.apacheigniteexample.repository.ProductRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") @ApiParam("id") String id) {
        return getProductById(id);
    }

    @PatchMapping("/{id}")
    public Product patch(@PathVariable("id") @ApiParam("id") String id,
                         @RequestBody UpdateProductDTO dto) {
        Product product =  getProductById(id);
        product.setListPrice(dto.getListPrice());
        productRepository.save(id, product);
        return product;
    }

    private Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }
}
