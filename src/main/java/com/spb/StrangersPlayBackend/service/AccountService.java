package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.dto.EditAccountDto;
import com.spb.StrangersPlayBackend.model.AccountModel;

public interface AccountService {
    AccountModel getUser(String userLogin);

    AccountDto getUserDetails(int id);

    AccountModel createUser(AccountDto accountDto);

    AccountModel updateUser(AccountModel accountModel);

    AccountDto editUserProfile(int id, EditAccountDto editAccountDto);
}
