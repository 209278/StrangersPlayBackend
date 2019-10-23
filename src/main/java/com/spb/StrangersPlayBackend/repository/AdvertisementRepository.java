package com.spb.StrangersPlayBackend.repository;

import com.spb.StrangersPlayBackend.model.AdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, Integer>{

    AdvertisementModel findAdvertisementById (int id);

    List<AdvertisementModel> findAll();

}
