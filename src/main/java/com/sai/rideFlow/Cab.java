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
public class Cab {
    @Id
    int cabID;
    int cabNo;
    String cabModel;
    int perkmRate;
    boolean available;
}
