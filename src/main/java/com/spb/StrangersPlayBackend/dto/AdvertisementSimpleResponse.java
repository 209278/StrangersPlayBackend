package com.spb.StrangersPlayBackend.dto;

import com.spb.StrangersPlayBackend.model.Category;
import com.spb.StrangersPlayBackend.model.UserInAdvertisementModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AdvertisementSimpleResponse {

    private int id;
    private Category category;
    private String title;
    private int level;
    private Double price;
    private int authorId;
    private int userLimit;
    private int usersJoined;
    private List<UserInAdvertisementModel> userIdsList;
    private String eventTime;
    private String eventLocation;
    private Instant creationTime;
}
