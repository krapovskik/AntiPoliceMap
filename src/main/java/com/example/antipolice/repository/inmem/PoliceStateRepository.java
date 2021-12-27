package com.example.antipolice.repository.inmem;

import com.example.antipolice.model.PoliceState;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PoliceStateRepository {
    private final List<PoliceState> policeStates;

    public PoliceStateRepository() {
        this.policeStates = new ArrayList<>(List.of(PoliceState.values()));
    }

    public List<PoliceState> allPoliceStates(){
        return this.policeStates;
    }
}
