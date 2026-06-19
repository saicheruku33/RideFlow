package com.sai.rideFlow.Repository;

import com.sai.rideFlow.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
