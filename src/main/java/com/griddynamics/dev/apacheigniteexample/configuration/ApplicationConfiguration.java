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
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setIgniteInstanceName("springDataNode");
        cfg.setPeerClassLoadingEnabled(true);
        CacheConfiguration ccfgProduct = new CacheConfiguration("ProductCache");
        ccfgProduct.setIndexedTypes(String.class, Product.class);
        cfg.setCacheConfiguration(new CacheConfiguration[] {
                ccfgProduct
        });
        return Ignition.start(cfg);
    }
}
