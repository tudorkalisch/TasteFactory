package ro.backend.tastefactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.backend.tastefactory.dao.IngredientDataAccessService;
import ro.backend.tastefactory.dao.RecipeDataAccessService;
import ro.backend.tastefactory.model.Recipe;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    RecipeDataAccessService recipeDao;

    @Autowired
    public void setRecipeDao(RecipeDataAccessService recipeDao) {
        this.recipeDao = recipeDao;
    }

    public Recipe getRecipe(Recipe recipe) {
        return recipeDao.findById(recipe.getId()).get();
    }

    public List<Recipe> getAll() {
        List<Recipe> recipes = new ArrayList<>();
        recipeDao.findAll().forEach(recipes::add);

        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public void addRecipes(List<Recipe> recipes) {
        recipeDao.saveAll(recipes);
    }

    public void deleteAll() {
        recipeDao.deleteAll();
    }
}
