package com.example.antipolice.service.impl;

import com.example.antipolice.model.LatLng;
import com.example.antipolice.model.MapCoordinates;
import com.example.antipolice.model.PoliceState;
import com.example.antipolice.model.User;
import com.example.antipolice.repository.MapCoordinatesRepository;
import com.example.antipolice.repository.UserRepository;
import com.example.antipolice.service.MapCoordinatesService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapCoordinatesServiceImpl implements MapCoordinatesService {

    private final MapCoordinatesRepository mapCoordinatesRepository;
    private final UserRepository userRepository;

    public MapCoordinatesServiceImpl(MapCoordinatesRepository mapCoordinatesRepository, UserRepository userRepository) {
        this.mapCoordinatesRepository = mapCoordinatesRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MapCoordinates save(String latlng, String state, String username) {
        String [] parts = latlng.split(", ");
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
        return mapCoordinatesRepository.save(new MapCoordinates(new LatLng(parts[0],parts[1]), PoliceState.valueOf(state),user));
    }

    @Override
    public List<MapCoordinates> findAll() {
        return mapCoordinatesRepository.findAll();
    }
}
