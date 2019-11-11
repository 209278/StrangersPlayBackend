package com.spb.StrangersPlayBackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity
@Data
public class AdvertisementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private Category category;
    private String title;
    private String description;
    private int level;
    private Double price;
    private String eventLocation;
    private String eventTime;
    @CreationTimestamp
    private Instant creationTime;
}
