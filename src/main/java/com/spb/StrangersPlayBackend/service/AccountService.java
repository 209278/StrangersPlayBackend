package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.model.AccountModel;

public interface AccountService {
    AccountModel getUser(String userLogin);

    void createUser(AccountDto accountDto);
}
