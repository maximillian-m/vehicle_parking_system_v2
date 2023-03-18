package com.Maximillian.vehicleparkingsystem.repository;

import com.Maximillian.vehicleparkingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Vehicle findVehicleByNumberPlate(String numberPlate);
}
