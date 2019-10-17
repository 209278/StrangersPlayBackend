package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.exception.NotUniqueUser;
import com.spb.StrangersPlayBackend.model.Account;
import com.spb.StrangersPlayBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Account getUser(String userLogin) {
        return userRepository.findAccountByLogin(userLogin);
    }

    @Override
    public void createUser(Account account) {
        if (getUser(account.getLogin())!=null) {
            throw new NotUniqueUser("Not unique User");
        } else {
            userRepository.save(account);
        }
    }
}
