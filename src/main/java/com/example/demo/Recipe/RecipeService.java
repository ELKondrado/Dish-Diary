package com.example.demo.Recipe;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;
@Service
public class RecipeService {
    @GetMapping
    public List<Recipe> getRecipes(){
        LinkedList<String> ingredients = new LinkedList<>();
        ingredients.add("Mere");
        ingredients.add("Zahar");
        return List.of(
                new Recipe("Placinta mere", ingredients, "Bati merele")
        );
    }
}
