package com.sai.rideFlow.Dto.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    String cabNo;
    String cabModel;
    double perkmRate;
    boolean available;
    DriverResponse driver;

}
