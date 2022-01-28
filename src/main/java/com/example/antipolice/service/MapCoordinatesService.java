package com.example.antipolice.service;

import com.example.antipolice.model.MapCoordinates;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MapCoordinatesService {
    MapCoordinates save(String latlng,String state,String username);
    List<MapCoordinates> findAll();
}
