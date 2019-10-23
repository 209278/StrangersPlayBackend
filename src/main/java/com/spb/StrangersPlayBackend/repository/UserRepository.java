package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<AccountModel, Integer> {

    AccountModel findAccountByUsername (String username);

    AccountModel findAccountByEmail (String email);

}
