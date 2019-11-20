package com.spb.StrangersPlayBackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
public class UserInAdvertisementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private int userId;

    public UserInAdvertisementModel(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }
}
