package com.sai.rideFlow;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Driver {
    @Id
    private int driverID;
    private String name;
    private int age;
    private String emailID;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_ID")
    List<Booking> bookings=new ArrayList<>();
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cab_Id")
    Cab cab;
}
