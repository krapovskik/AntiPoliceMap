package com.example.antipolice.model;


import com.example.antipolice.model.converters.LatLngConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class MapCoordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long mapId;

    LocalDateTime timeSubmited;

    @Convert(converter = LatLngConverter.class)
    LatLng latlng;

    @Enumerated(EnumType.STRING)
    MapCoordStatus status;

    @Enumerated(EnumType.STRING)
    PoliceState state;

    @ManyToOne
    User user;

    public MapCoordinates() {
    }

    public MapCoordinates(LatLng latlng, PoliceState state,User user) {
        this.latlng = latlng;
        this.state = state;
        this.status = MapCoordStatus.VALID;
        this.timeSubmited = LocalDateTime.now();
        this.user = user;
    }

    public MapCoordinates(LatLng latlng) {
        this.latlng = latlng;
    }
}
