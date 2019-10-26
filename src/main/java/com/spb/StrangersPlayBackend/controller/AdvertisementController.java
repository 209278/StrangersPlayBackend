package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.AdvertisementDto;
import com.spb.StrangersPlayBackend.dto.AdvertisementSimpleResponse;
import com.spb.StrangersPlayBackend.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        System.out.println("asd");
        return advertisementService.getAdvertisementDetails(id);
    }
}
