package com.sai.rideFlow;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    private int customerID;
    private String name;
    private int age;
    private String emailID;
    private Gender gender;
    @OneToMany
    @JoinColumn(name="customerId")
    List<Booking> bookings=new ArrayList<>();
}
