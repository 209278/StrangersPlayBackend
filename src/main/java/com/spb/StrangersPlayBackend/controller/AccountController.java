package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.model.Account;
import com.spb.StrangersPlayBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @PostMapping("/employee/save")
    public ResponseEntity createEmployee(@RequestBody Account account) {
        accountService.createUser(account);
        return ResponseEntity.ok().build();
    }
}
