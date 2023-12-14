package com.example.recipeapp.Controllers;

import com.example.recipeapp.Model.Recipe;
import com.example.recipeapp.Model.User;
import com.example.recipeapp.Services.RecipeService;
import com.example.recipeapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    private final UserService userService;

    @Autowired
    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getRecipes(){
        List<Recipe> recipes = recipeService.getRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id){
        Recipe recipe = recipeService.findRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> registerNewRecipe(@RequestBody Recipe recipe){
        Recipe newRecipe = recipeService.addNewRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    @PostMapping("/addUserRecipe")
    public ResponseEntity<Recipe> registerNewRecipe(@RequestBody Recipe recipe,
                                                    @RequestParam("username") String username) {
        Optional<User> optionalUser = userService.findUserByUserName(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Recipe newRecipe = recipeService.addNewRecipe(recipe, user);

            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{recipeId}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable("recipeId") Long recipeId){
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("recipeId") long recipeId,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String ingredients,
                                               @RequestParam(required = false) String stepsOfPreparation){
        Recipe recipe;
        recipe = recipeService.updateRecipeName(recipeId, name);
        recipe = recipeService.updateRecipeIngredients(recipeId, ingredients);
        recipe = recipeService.updateRecipeStepsOfPreparation(recipeId, stepsOfPreparation);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
}
