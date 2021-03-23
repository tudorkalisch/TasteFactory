package ro.backend.tastefactory.service;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.backend.tastefactory.dao.UserDataAccessService;
import ro.backend.tastefactory.model.User;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {
    UserDataAccessService userDao;

    @Autowired
    public void setUserDataAccessService(UserDataAccessService userDao) {
        this.userDao = userDao;
    }

    public void register(User user) throws DuplicateMemberException {
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);

        AtomicReference<User> foundUser = new AtomicReference<>();
        users.forEach(u -> {
            if (u.getUsername().equals(user.getUsername()) && user.getPassword().equals(u.getPassword())) {
                foundUser.set(u);
            }
        });

        if (foundUser.get() != null) {
            throw new DuplicateMemberException("User already registered");
        }

        userDao.save(user);
    }

    public User login(User user) throws AuthenticationException {
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);

        AtomicReference<User> foundUser = new AtomicReference<>();
        users.forEach(u -> {
            if (u.getUsername().equals(user.getUsername()) && user.getPassword().equals(u.getPassword())) {
                foundUser.set(u);
            }
        });

        if (foundUser.get() == null) {
            throw new AuthenticationException("Login unsuccessful");
        }

        return foundUser.get();
    }
}
