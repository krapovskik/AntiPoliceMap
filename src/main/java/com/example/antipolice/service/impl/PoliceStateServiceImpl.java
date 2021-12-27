package com.example.antipolice.service.impl;

import com.example.antipolice.model.PoliceState;
import com.example.antipolice.repository.inmem.PoliceStateRepository;
import com.example.antipolice.service.PoliceStateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceStateServiceImpl implements PoliceStateService {

    private final PoliceStateRepository policeStateRepository;

    public PoliceStateServiceImpl(PoliceStateRepository policeStateRepository) {
        this.policeStateRepository = policeStateRepository;
    }

    @Override
    public List<PoliceState> findAll() {
        return policeStateRepository.allPoliceStates();
    }
}
