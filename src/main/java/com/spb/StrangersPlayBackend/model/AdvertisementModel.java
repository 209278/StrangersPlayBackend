package com.spb.StrangersPlayBackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Data
public class AdvertisementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Category category;
    private String title;
    private String description;
    private int level;
    private Double price;
    private String eventLocation;
    private int authorId;
    private byte[] image;
    private String eventTime;
    private int userLimit;
    @ElementCollection
    private List<Integer> userIdsList = new ArrayList<>();
    @CreationTimestamp
    private Instant creationTime;

    public void addUserIdToUserList(int id) {
        userIdsList.add(id);
    }

    public void deleteUserIdFromUserList(int id) {
        userIdsList.remove(userIdsList.indexOf(id));
    }
}
