package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AccountDto;
import com.spb.StrangersPlayBackend.exception.NotUniqueUser;
import com.spb.StrangersPlayBackend.mapper.DefaultMapper;
import com.spb.StrangersPlayBackend.model.AccountModel;
import com.spb.StrangersPlayBackend.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private MapperFacade mapperFacade = new DefaultMapper();

    @Override
    public AccountModel getUser(String username) {
        return userRepository.findAccountByUsername(username);
    }

    public void createUser(AccountDto accountDto) {
        if (getUser(accountDto.getUsername()) != null) {
            throw new NotUniqueUser("Not unique Username");
        } else if (userRepository.findAccountByEmail(accountDto.getEmail()) != null) {
            throw new NotUniqueUser("Not unique Email");
        } else {
            accountDto.setActive(true);
            accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            userRepository.save(mapperFacade.map(accountDto, AccountModel.class));
        }
    }
}

