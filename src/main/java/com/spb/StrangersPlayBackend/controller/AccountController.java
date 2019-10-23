package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.response.CustomResponse;
import com.spb.StrangersPlayBackend.exception.NotUniqueUser;
import com.spb.StrangersPlayBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity createEmployee(@Valid @RequestBody AccountDto accountDto) {
        try {
            accountService.createUser(accountDto);
            return ResponseEntity.status(201).body(new CustomResponse(201, "Account Created"));
        } catch (NotUniqueUser e) {
            return ResponseEntity.status(409).body(new CustomResponse(409, e.getMessage()));
        }
    }
}
