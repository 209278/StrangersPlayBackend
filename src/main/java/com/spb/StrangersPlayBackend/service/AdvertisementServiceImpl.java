package com.spb.StrangersPlayBackend.service;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.exception.*;
import com.spb.StrangersPlayBackend.mapper.DefaultMapper;
import com.spb.StrangersPlayBackend.model.AdvertisementModel;
import com.spb.StrangersPlayBackend.model.UserInAdvertisementModel;
import com.spb.StrangersPlayBackend.repository.AdvertisementRepository;
import com.spb.StrangersPlayBackend.repository.UserInAdvertisementRepository;
import com.spb.StrangersPlayBackend.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInAdvertisementRepository userInAdvertisementRepository;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public AdvertisementModel addNewAdvertisement(AdvertisementDto advertisementDto) {
        advertisementDto.setUsersJoined(0);
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
    public void deleteAdvertisement(int id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public AdvertisementDto joinAdvertisement(int id, int userId) {
        AdvertisementModel advertisement = advertisementRepository.findAdvertisementById(id);
        UserInAdvertisementModel user;
        if(userRepository.findAccountModelById(userId) == null ) {
            throw new UserNotFoundException("User not Found");
        }
        if(advertisement.getUserLimit() <= advertisement.getUsersJoined()) {
            throw new AdvertisementIsFullException("Advertisement is full");
        } else {
            if(userInAdvertisementRepository.findByUserId(userId) == null) {
                user = new UserInAdvertisementModel(userRepository.findAccountModelById(userId).getUsername(), userId);
            } else {
                user = userInAdvertisementRepository.findByUserId(userId);
            }
            if(!advertisement.getUserIdsList().contains(user) && ! (advertisement.getAuthorId()== userId))  {
                advertisement.setUsersJoined(advertisement.getUsersJoined() + 1);
                advertisement.addUserIdToUserList(user);
                userInAdvertisementRepository.save(user);
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
            UserInAdvertisementModel user = userInAdvertisementRepository.findByUserId(userId);
            if(advertisement.getUserIdsList().contains(user)) {
                advertisement.deleteUserIdFromUserList(user);
                advertisement.setUsersJoined(advertisement.getUsersJoined() - 1);
                return mapper.map(advertisementRepository.save(advertisement), AdvertisementDto.class);
            } else {
                throw new UserIsNotInAdvertisementException("User is not in advertisement");
            }
        }
    }
}
