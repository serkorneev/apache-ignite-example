package com.griddynamics.dev.apacheigniteexample;

import com.griddynamics.dev.apacheigniteexample.configuration.ApplicationConfiguration;
import com.griddynamics.dev.apacheigniteexample.repository.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ApplicationConfiguration.class);
        context.refresh();

        ProductRepository repository = context.getBean(ProductRepository.class);

        System.out.println(repository.findById("test"));
    }
}
