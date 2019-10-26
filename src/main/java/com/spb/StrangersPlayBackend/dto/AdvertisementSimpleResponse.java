package com.spb.StrangersPlayBackend.dto;

import com.spb.StrangersPlayBackend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class AdvertisementSimpleResponse {

    private int id;
    private Category category;
    private String title;
    private int level;
    private Double price;
    private Instant eventTime;
    private String eventLocation;
    private Instant creationTime;
}
