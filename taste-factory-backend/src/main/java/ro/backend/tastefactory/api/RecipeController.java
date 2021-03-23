package ro.backend.tastefactory.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.backend.tastefactory.model.Recipe;
import ro.backend.tastefactory.service.RecipeService;

import java.util.List;

@RequestMapping("api/v1/recipe")
@CrossOrigin
@RestController
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<Recipe> getRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(recipeService.getRecipe(recipe));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok().body(recipeService.getAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<String> deleteAll() {
        recipeService.deleteAll();
        return ResponseEntity.ok().build();
    }

}

