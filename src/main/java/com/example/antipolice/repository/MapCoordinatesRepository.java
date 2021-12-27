package com.example.antipolice.repository;

import com.example.antipolice.model.MapCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapCoordinatesRepository extends JpaRepository<MapCoordinates,Long> {
}
