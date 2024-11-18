//package org.application.start.controller;
//
//import org.application.start.model.User;
//import org.application.start.operation.UserManager;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private UserManager userManager;
//
//    public UserController(UserManager userRepository) {
//        this.userManager = userRepository;
//    }
//
//
//    @PostMapping
//    public void addUser(@RequestBody User user) {
//        userManager.addUser(user);
//    }
//
//    @PutMapping("/{username}")
//    public void updateUser(@PathVariable String username, @RequestBody User user) {
//        userManager.updateUser(username, user);
//    }
//
//    @DeleteMapping("/{username}")
//    public void deleteUser(@PathVariable String username) {
//        userManager.deleteUser(username);
//    }
//}
//
