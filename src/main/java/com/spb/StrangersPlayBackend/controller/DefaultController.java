package com.spb.StrangersPlayBackend.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DefaultController {

    @GetMapping
    public ResponseEntity home() {
        return ResponseEntity.status(200).body(new JSONObject()
                .put("httpCode", 200)
                .put("message", "Logged").toString());
    }
}
