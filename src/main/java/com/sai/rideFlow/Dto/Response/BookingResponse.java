package com.sai.rideFlow.Dto.Response;

import com.sai.rideFlow.Enum.TripStatus;
import com.sai.rideFlow.Model.Customer;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    private String pickup;
    private String destination;
    private double tripDistKm;
    private TripStatus tripStatus;
    private double billAmount;
    private double perkmRate;
    Date bookedAt;
    Date lastUpdated;
    CustomerResponse customerResponse;
    CabResponse cabResponse;

}
