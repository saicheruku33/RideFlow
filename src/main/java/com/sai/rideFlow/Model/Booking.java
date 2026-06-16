package com.sai.rideFlow.Model;

import com.sai.rideFlow.Enum.TripStatus;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingID;
    private String pickup;
    private String destination;
    private int tripDistKm;
    @Enumerated(value=EnumType.STRING)
    private TripStatus tripStatus;
    private int billAmount;
}
