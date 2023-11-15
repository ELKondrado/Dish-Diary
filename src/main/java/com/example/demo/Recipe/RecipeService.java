package com.example.demo.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public void addNewRecipe(Recipe recipe) {
        Optional<Recipe> recipeOptional = recipeRepository.findRecipeByName(recipe.getName());
        if(recipeOptional.isPresent()){
            throw new IllegalStateException("Name taken");
        }
        recipeRepository.save(recipe);
    }
}
