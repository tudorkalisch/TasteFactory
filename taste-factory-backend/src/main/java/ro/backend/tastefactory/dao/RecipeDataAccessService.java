package ro.backend.tastefactory.dao;

import org.springframework.data.repository.CrudRepository;
import ro.backend.tastefactory.model.Recipe;

import java.util.UUID;

public interface RecipeDataAccessService extends CrudRepository<Recipe, UUID> {
}
