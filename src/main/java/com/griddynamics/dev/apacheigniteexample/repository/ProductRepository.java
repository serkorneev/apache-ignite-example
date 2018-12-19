package com.griddynamics.dev.apacheigniteexample.repository;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import org.apache.ignite.springdata20.repository.config.Query;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;
import org.apache.ignite.springdata20.repository.IgniteRepository;

@RepositoryConfig(cacheName = "ProductCache")
public interface ProductRepository extends IgniteRepository<Product, String> {

    @Query("SELECT p.* FROM Product p WHERE p.uniq_id = ?")
    Product findProductById(String id);
}
