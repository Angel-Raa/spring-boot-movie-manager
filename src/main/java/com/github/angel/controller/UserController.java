package com.github.angel.controller;

import com.github.angel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RequestMapping("/profile")
@RestController
public class UserController {
    private final UserService userService;
}
