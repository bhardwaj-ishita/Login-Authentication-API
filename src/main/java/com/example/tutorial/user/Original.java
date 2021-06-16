package com.example.tutorial.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * This class is not being used in the functioning of user sign in/sign up
 * This is the original Api format.
 */

@RestController
public class Original {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody @ModelAttribute User newUser) {
        System.out.println("Posted it");
        List<User> users
                = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {//if the user is in our db then set log in true
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;//and return success
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}