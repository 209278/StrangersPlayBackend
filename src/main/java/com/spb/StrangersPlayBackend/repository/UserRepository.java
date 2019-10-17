package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface UserRepository extends JpaRepository<Account, Integer> {

    Account findAccountByLogin(String login);

}
