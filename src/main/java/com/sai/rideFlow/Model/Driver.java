package com.sai.rideFlow.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverID;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String emailID;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_ID")
    List<Booking> bookings=new ArrayList<>();
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cab_Id")
    private Cab cab;
}
