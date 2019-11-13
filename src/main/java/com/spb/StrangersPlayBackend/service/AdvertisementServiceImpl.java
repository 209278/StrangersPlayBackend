package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.exception.AdvertisementIsFullException;
import com.spb.StrangersPlayBackend.exception.AuthorCanNotLeaveAdvertisementException;
import com.spb.StrangersPlayBackend.exception.UserAlreadyJoinAdvertisementException;
import com.spb.StrangersPlayBackend.exception.UserIsNotInAdvertisementException;
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

    @Override
    public AdvertisementDto joinAdvertisement(int id, int userId) {
        AdvertisementModel advertisement = advertisementRepository.findAdvertisementById(id);
        if(advertisement.getUserLimit() == 0) {
            throw new AdvertisementIsFullException("Advertisement is full");
        } else {
            if(!advertisement.getUserIdsList().contains(userId) && ! (advertisement.getAuthorId()== userId))  {
                advertisement.setUserLimit(advertisement.getUserLimit()-1);
                advertisement.addUserIdToUserList(userId);
                return mapper.map(advertisementRepository.save(advertisement), AdvertisementDto.class);
            } else {
                throw new UserAlreadyJoinAdvertisementException("User already join advertisement");
            }
        }
    }

    @Override
    public AdvertisementDto leaveAdvertisement(int id, int userId) {
        AdvertisementModel advertisement = advertisementRepository.findAdvertisementById(id);
        if(userId == advertisement.getAuthorId()) {
            throw new AuthorCanNotLeaveAdvertisementException("Author can not leave advertisement");
        } else {
            if(advertisement.getUserIdsList().contains(userId)) {
                advertisement.deleteUserIdFromUserList(userId);
                advertisement.setUserLimit(advertisement.getUserLimit()+1);
                return mapper.map(advertisementRepository.save(advertisement), AdvertisementDto.class);
            } else {
                throw new UserIsNotInAdvertisementException("User is not in advertisement");
            }
        }
    }
}
