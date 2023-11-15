package com.example.demo.Recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecipeConfig {
    @Bean
    CommandLineRunner commandLineRunner(RecipeRepository repository){
        return args -> {
            Recipe cake = new Recipe("Placinta mere", null, "Bati merele");
            Recipe pizza = new Recipe("Pizza salami", null, "Bati aluat lmao");
            repository.saveAll(List.of(cake, pizza));
        };
    }
}
