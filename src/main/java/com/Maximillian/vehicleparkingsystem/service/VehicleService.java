package com.Maximillian.vehicleparkingsystem.service;

import com.Maximillian.vehicleparkingsystem.dto.request.VehicleRequest;
import com.Maximillian.vehicleparkingsystem.dto.response.VehicleResponse;

import java.util.List;

public interface VehicleService {
    VehicleResponse addVehicle(VehicleRequest vehicleRequest);

    VehicleRequest getVehicle(String vehicleId);

    List<VehicleRequest> getAllVehicle();

    VehicleResponse deleteVehicle(String vehicleId);

    VehicleRequest searchVehicle(String numberPlate);
}
