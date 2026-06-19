package com.sai.rideFlow.Dto.Request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookingRequest {

    private String pickup;
    private String destination;
    private int tripDistKm;
}
