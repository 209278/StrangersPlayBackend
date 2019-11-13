package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.model.AdvertisementModel;

import java.util.List;

public interface AdvertisementService {

    AdvertisementModel addNewAdvertisement(AdvertisementDto advertisementDto);

    AdvertisementDto getAdvertisementDetails(int id);

    List<AdvertisementSimpleResponse> getListOfAllAdvertisement();

    AdvertisementDto joinAdvertisement(int id, int userId);

    AdvertisementDto leaveAdvertisement(int id, int userId);
}
