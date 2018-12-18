package com.griddynamics.dev.apacheigniteexample.configuration;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableIgniteRepositories("com.griddynamics.dev.apacheigniteexample.repository")
public class ApplicationConfiguration {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration config = new IgniteConfiguration();

        CacheConfiguration cache = new CacheConfiguration("ProductCache");
        cache.setIndexedTypes(String.class, Product.class);

        config.setCacheConfiguration(cache);
        return Ignition.start(config);
    }
}
