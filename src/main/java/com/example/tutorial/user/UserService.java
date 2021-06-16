package com.example.tutorial.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @PostMapping("/user/register")
    public String registerUser(User newUser) {
        log.info(">> newUser :  {}", newUser.toString());
        log.info("Posted it");
        List<User> users = userRepository.findAll();
        log.info("New user: " + newUser.toString());
        for (User user : users) {
            log.info("Registered user: " + users.toString());
            if (user.equals(newUser)) {
                log.info("User Already exists!");
                return "register.html";
            }
        }
        userRepository.save(newUser);
        return "login.html";
    }

    @PostMapping("/user/login")
    public String loginUser(User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                log.info("Logged In");
                user.setLoggedIn(true);
                userRepository.save(user);
                return "dashboard.html";
            }
        }
        return "login.html";
    }

    @DeleteMapping("/user/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}
