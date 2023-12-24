import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../../Models/Recipe/recipe.service';
import { AuthService } from '../../Security/auth.service';
import { UserService } from '../../Models/User/user.service';
import { Router } from '@angular/router';
import { Recipe } from '../../Models/Recipe/recipe';
import { UserDto } from '../../Models/User/userDto';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-discover-recipes',
  templateUrl: './discover-recipes.component.html',
  styleUrl: './discover-recipes.component.css'
})
export class DiscoverRecipesComponent implements OnInit{
  constructor(
    private recipeService: RecipeService,
    private authService: AuthService, 
    private userService: UserService,
    private router: Router
  ) {}

  public user: UserDto | null = null;
  public recipes: Recipe[] = [];
  public editRecipe: Recipe | undefined;
  public deletedRecipe: Recipe | undefined;
  public username: string | undefined;

  ngOnInit(): void {
    this.fetchRecipes();
  }

  private fetchRecipes(): void {
    this.authService.initializeApp().then(() => {
      this.user = this.authService.getUser();
      this.username = this.userService.getUsername();
      this.getRecipes();
    });
  }
  public getRecipes(): void {
    this.recipeService.getRecipes().subscribe(
      (response: any) => {
        console.log(response);
        this.recipes = response;
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    );
  }

  public searchRecipe(key: string): void {
    const resultRecipes: Recipe[] = [];
    for (const recipe of this.recipes) {
      if (recipe.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        resultRecipes.push(recipe);
      }
    }
    this.recipes = resultRecipes;
    if (resultRecipes.length === 0 || !key){
      this.fetchRecipes();
    }
  }

  public logout(): void {   
    this.authService.logout();
  }
}
