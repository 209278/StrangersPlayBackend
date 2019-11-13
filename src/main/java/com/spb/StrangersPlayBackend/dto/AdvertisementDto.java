package com.spb.StrangersPlayBackend.dto;

import com.spb.StrangersPlayBackend.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class AdvertisementDto {

    private int id;
    @NotNull
    private Category category;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private int level;
    @NotNull
    private Double price;
    @NotNull
    private String eventLocation;
    @NotNull
    private String eventTime;
    private Instant creationTime;
    private int authorId;
    private byte[] image;
    private int userLimit;
    private List<Integer> userIdsList;


}
