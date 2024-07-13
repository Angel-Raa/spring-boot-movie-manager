package com.github.angel.controller;

import com.github.angel.persistence.entity.User;
import com.github.angel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/profile")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @GetMapping("/name")
    public ResponseEntity<List<User>> getAllByName(@RequestParam(name = "name", required = false) String name){
        List<User> users;
        if(StringUtils.hasText(name)){
            users = userService.getAllByName(name);
        }
        else {
            users = userService.getAll();
        }
        return ResponseEntity.ok(users);
    }



}
