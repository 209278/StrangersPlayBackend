package com.spb.StrangersPlayBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthContoller {

    @GetMapping
    public String health() {
        return "Running";
    }
}
