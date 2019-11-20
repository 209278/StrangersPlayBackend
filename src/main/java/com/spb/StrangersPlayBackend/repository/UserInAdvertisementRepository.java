package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.UserInAdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInAdvertisementRepository extends JpaRepository<UserInAdvertisementModel, Integer> {

    UserInAdvertisementModel findByUserId(int userId);
}
