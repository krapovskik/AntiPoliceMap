package com.example.antipolice.service.impl;

import com.example.antipolice.model.LatLng;
import com.example.antipolice.model.MapCoordinates;
import com.example.antipolice.model.PoliceState;
import com.example.antipolice.repository.MapCoordinatesRepository;
import com.example.antipolice.service.MapCoordinatesService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapCoordinatesServiceImpl implements MapCoordinatesService {

    private final MapCoordinatesRepository mapCoordinatesRepository;

    public MapCoordinatesServiceImpl(MapCoordinatesRepository mapCoordinatesRepository) {
        this.mapCoordinatesRepository = mapCoordinatesRepository;
    }

    @Override
    public MapCoordinates save(String latlng, String state) {
        String [] parts = latlng.split(", ");
        return mapCoordinatesRepository.save(new MapCoordinates(new LatLng(parts[0],parts[1]), PoliceState.valueOf(state)));
    }

    @Override
    public List<MapCoordinates> findAll() {
        return mapCoordinatesRepository.findAll();
    }
}
