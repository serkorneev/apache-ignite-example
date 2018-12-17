package com.griddynamics.dev.apacheigniteexample.repository;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "ProductCache")
public interface ProductRepository extends IgniteRepository<Product, String> {

    @Query("SELECT p.* FROM Product p WHERE p.uniq_id = ?")
    Product findById(String id);
}
