package com.github.angel.controller;

import com.github.angel.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;
}
