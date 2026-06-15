package com.sai.rideFlow;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Booking {
    @Id
    private int bookingID;
    private String pickup;
    private String destination;
    private int tripDistKm;
    TripStatus tripStatus;
    int billAmount;
}
