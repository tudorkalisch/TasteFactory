package ro.backend.tastefactory.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.backend.tastefactory.model.Ingredient;
import ro.backend.tastefactory.service.IngredientService;

import java.util.List;

@RequestMapping("api/v1/ingredient")
@CrossOrigin
@RestController
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @PostMapping(value = "/addAll")
    public ResponseEntity<String> addIngredients(@RequestBody List<Ingredient> ingredients) {
        ingredientService.addIngredients(ingredients);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<String> deleteAll() {
        ingredientService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getRecommended")
    public ResponseEntity<List<Ingredient>> getIngredientsRecommended(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.getIngredientsByType(ingredient.getType()));
    }

    @GetMapping(value = "/getRecommendedAndSimilar")
    public ResponseEntity<List<Ingredient>> getIngredientsRecommendedAndSimilar(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.getIngredientsByTypeAndSimilar(ingredient.getType(), ingredient.getCalories()));
    }
}
