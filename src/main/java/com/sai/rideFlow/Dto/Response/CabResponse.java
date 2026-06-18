package com.sai.rideFlow.Dto.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    private String cabNo;
    private String cabModel;
    private int perkmRate;
    private boolean available;
    private DriverResponse driver;

}
