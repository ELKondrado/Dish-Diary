package com.example.demo.Recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class RecipeConfig {
    CommandLineRunner commandLineRunner(RecipeRepository repository){
        return args -> {
            Recipe cake = new Recipe("Placinta mere", "Mere;Zahar;Iubire", "Bati merele");
            Recipe pizza = new Recipe("Pizza salami", "Salam;Faina;Iubire;Mozzarella", "Bati aluat lmao");
            repository.saveAll(List.of(cake, pizza));
        };
    }
}
