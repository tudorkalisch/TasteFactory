package ro.backend.tastefactory.api;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.backend.tastefactory.model.User;
import ro.backend.tastefactory.service.UserService;

import javax.naming.AuthenticationException;

@RequestMapping("api/v1/user")
@CrossOrigin
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.register(user);
        } catch (DuplicateMemberException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody User user) {

        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }
}