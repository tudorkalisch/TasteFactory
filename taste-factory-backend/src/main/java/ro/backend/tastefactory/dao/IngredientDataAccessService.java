package ro.backend.tastefactory.dao;

import org.springframework.data.repository.CrudRepository;
import ro.backend.tastefactory.model.Ingredient;

import java.util.UUID;

public interface IngredientDataAccessService extends CrudRepository<Ingredient, UUID> {
}
