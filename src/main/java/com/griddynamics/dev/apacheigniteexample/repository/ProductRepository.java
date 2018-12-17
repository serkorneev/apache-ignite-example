package com.griddynamics.dev.apacheigniteexample.repository;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "ProductCache")
public interface ProductRepository extends IgniteRepository<Product, String> {

    //can be removed after fix issue in IgniteRepository
    void deleteAll(Iterable var1);
}
