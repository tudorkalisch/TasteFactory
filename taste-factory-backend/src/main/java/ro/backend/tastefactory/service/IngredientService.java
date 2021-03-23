package ro.backend.tastefactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.backend.tastefactory.dao.IngredientDataAccessService;
import ro.backend.tastefactory.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {
    private final static int CALORIES_RANGE = 50;
    IngredientDataAccessService ingredientDao;

    @Autowired
    public void setIngredientDao(IngredientDataAccessService ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientDao.findAll().forEach(ingredients::add);

        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    public void addIngredients(List<Ingredient> ingredients) {
        ingredientDao.saveAll(ingredients);
    }

    public void deleteAll() {
        ingredientDao.deleteAll();
    }

    public List<Ingredient> getIngredientsByType(String type) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientDao.findAll().forEach(ingredient -> {
            if(ingredient.getType().equals(type)) {
                ingredients.add(ingredient);
            }
        });

        return ingredients;
    }

    public List<Ingredient> getIngredientsByTypeAndSimilar(String type, int calories) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientDao.findAll().forEach(ingredient -> {
            if(ingredient.getType().equals(type) && (ingredient.getCalories()-CALORIES_RANGE >= calories || calories <= ingredient.getCalories()+CALORIES_RANGE)) {
                ingredients.add(ingredient);
            }
        });

        return ingredients;
    }
}
