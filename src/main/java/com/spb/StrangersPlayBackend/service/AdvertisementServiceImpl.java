package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.mapper.DefaultMapper;
import com.spb.StrangersPlayBackend.model.AdvertisementModel;
import com.spb.StrangersPlayBackend.repository.AdvertisementRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public AdvertisementModel addNewAdvertisement(AdvertisementDto advertisementDto) {
        return advertisementRepository.save(mapper.map(advertisementDto, AdvertisementModel.class));
    }

    @Override
    public AdvertisementDto getAdvertisementDetails(int id) {
        return mapper.map(advertisementRepository.findAdvertisementById(id), AdvertisementDto.class);
    }

    @Override
    public List<AdvertisementSimpleResponse> getListOfAllAdvertisement() {
        return advertisementRepository.findAll().stream()
                .map(advertisementModel -> mapper.map(advertisementModel, AdvertisementSimpleResponse.class))
                .collect(Collectors.toList());
    }
}
