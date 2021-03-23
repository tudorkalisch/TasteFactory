package ro.backend.tastefactory.dao;

import org.springframework.data.repository.CrudRepository;
import ro.backend.tastefactory.model.User;

import java.util.UUID;

public interface UserDataAccessService extends CrudRepository<User, UUID> {
}
