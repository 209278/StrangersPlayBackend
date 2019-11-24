package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.exception.*;
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

    @GetMapping("/advertisement")
    public List<AdvertisementSimpleResponse> getAdvertisementList() {
        return advertisementService.getListOfAllAdvertisement();
    }

    @GetMapping(value = "/advertisement/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdvertisementDto getAdvertisementDetails(@PathVariable int id) {
        return advertisementService.getAdvertisementDetails(id);
    }

    @DeleteMapping("/advertisement/{id}")
    public ResponseEntity deleteAdvertisement(@PathVariable int id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.status(200).body(new CustomResponse(200, "Deleted"));
    }

    @PostMapping("/advertisement/{id}/join/{userId}")
    public ResponseEntity joinAdvertisement(@PathVariable int id, @PathVariable int userId) {
        try {
            advertisementService.joinAdvertisement(id, userId);
            return ResponseEntity.status(200).body(new CustomResponse(200, "User joined"));
        } catch (AdvertisementIsFullException | UserAlreadyJoinAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).body(new CustomResponse(404, e.getMessage()));
        }
    }

    @DeleteMapping("/advertisement/{id}/join/{userId}")
    public ResponseEntity leaveAdvertisement(@PathVariable int id, @PathVariable int userId) {
        try {
            advertisementService.leaveAdvertisement(id, userId);
            return ResponseEntity.status(200).body(new CustomResponse(200, "User left"));
        } catch (UserIsNotInAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        } catch (AuthorCanNotLeaveAdvertisementException e) {
            return ResponseEntity.status(400).body(new CustomResponse(400, e.getMessage()));
        }
    }

}
