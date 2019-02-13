package com.griddynamics.dev.apacheigniteexample.configuration;

import com.griddynamics.dev.apacheigniteexample.entity.Product;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.store.cassandra.CassandraCacheStoreFactory;
import org.apache.ignite.cache.store.cassandra.datasource.DataSource;
import org.apache.ignite.cache.store.cassandra.persistence.KeyValuePersistenceSettings;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableIgniteRepositories("com.griddynamics.dev.apacheigniteexample.repository")
public class ApplicationConfiguration {

    @Bean
    public DataSource cassandraDataSource() {
        DataSource datasource = new DataSource();
        datasource.setContactPoints("cassandra");
        datasource.setPort(9042);
        datasource.setUser("cassandra");
        datasource.setPassword("cassandra");
        datasource.setReadConsistency("ONE");
        datasource.setWriteConsistency("ALL");
        return datasource;
    }

    @Bean
    public CassandraCacheStoreFactory cassandraCacheStoreFactory(DataSource dataSource) {
        CassandraCacheStoreFactory factory = new CassandraCacheStoreFactory();
        factory.setDataSource(dataSource);

        KeyValuePersistenceSettings persistenceSettings =
                new KeyValuePersistenceSettings(new ClassPathResource("persistence.xml"));
        factory.setPersistenceSettings(persistenceSettings);
        return factory;
    }

    @Bean
    public Ignite igniteInstance(CassandraCacheStoreFactory cacheStoreFactory) {
        IgniteConfiguration config = new IgniteConfiguration();

        CacheConfiguration cache = new CacheConfiguration("ProductCache");
        cache.setWriteThrough(true);
        cache.setReadThrough(true);
        cache.setSqlSchema("product");
        cache.setIndexedTypes(String.class, Product.class);
        cache.setCacheStoreFactory(cacheStoreFactory);
        cache.setStatisticsEnabled(true);
        cache.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 1)));

        config.setCacheConfiguration(cache);

        return Ignition.start(config);
    }
}
