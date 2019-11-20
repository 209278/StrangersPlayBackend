package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.exception.AdvertisementIsFullException;
import com.spb.StrangersPlayBackend.exception.AuthorCanNotLeaveAdvertisementException;
import com.spb.StrangersPlayBackend.exception.UserAlreadyJoinAdvertisementException;
import com.spb.StrangersPlayBackend.exception.UserIsNotInAdvertisementException;
import com.spb.StrangersPlayBackend.response.CustomResponse;
import com.spb.StrangersPlayBackend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @PostMapping("/advertisement")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdvertisement(@Valid @RequestBody AdvertisementDto advertisementDto) {
        advertisementService.addNewAdvertisement(advertisementDto);
    }

    public List<AdvertisementSimpleResponse> getAdvertisementList() {
        return advertisementService.getListOfAllAdvertisement();
    }

    @GetMapping(value = "/advertisement/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdvertisementDto getAdvertisementDetails(@PathVariable int id) {
        return advertisementService.getAdvertisementDetails(id);
    }

    @DeleteMapping("/advertisement/{id}")
    public ResponseEntity deleteAdvertisement(@PathVariable int id){
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.status(200).body(new CustomResponse(200, "Deleted"));
    }

    @PostMapping("/advertisement/{id}/join/{userId}")
    public ResponseEntity joinAdvertisement(@PathVariable int id, @PathVariable int userId) {
        try {
            return ResponseEntity.status(200).body(advertisementService.joinAdvertisement(id, userId));
        } catch (AdvertisementIsFullException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        } catch (UserAlreadyJoinAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        }
    }

    @DeleteMapping("/advertisement/{id}/join/{userId}")
    public ResponseEntity leaveAdvertisement(@PathVariable int id, @PathVariable int userId) {
        try {
            return ResponseEntity.status(200).body(advertisementService.leaveAdvertisement(id, userId));
        } catch (UserIsNotInAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        } catch (AuthorCanNotLeaveAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        }
    }

}
