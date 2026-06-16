package com.sai.rideFlow.Model;

import com.sai.rideFlow.Enum.Gender;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;
    private String name;
    private int age;
    private String emailID;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="customerId")
    List<Booking> bookings=new ArrayList<>();
}
