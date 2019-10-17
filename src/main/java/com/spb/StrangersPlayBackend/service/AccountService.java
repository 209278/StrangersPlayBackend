package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.model.Account;

public interface AccountService {
    Account getUser(String userLogin);

    void createUser(Account account);
}
