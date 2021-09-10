package com.test.cosmodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/users", method= RequestMethod.GET, headers="Accept=application/xml, application/json")
    public @ResponseBody List<User> getUsers() {
        List<User> users =  new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            users.add(user);
        }
        return users;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, headers="Accept=application/xml, application/json")
    public @ResponseBody User addEmployee(@RequestBody User user) {
        User save = userRepository.save(user);
        return save;
    }

}
