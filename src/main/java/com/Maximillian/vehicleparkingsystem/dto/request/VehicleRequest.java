package com.Maximillian.vehicleparkingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRequest {
    private String category;
    private String numberPlate;
    private String colour;
    private String ownerName;
}
