package com.sai.rideFlow.Transformer;

import com.sai.rideFlow.Dto.Request.BookingRequest;
import com.sai.rideFlow.Dto.Response.BookingResponse;
import com.sai.rideFlow.Enum.TripStatus;
import com.sai.rideFlow.Model.Booking;
import com.sai.rideFlow.Model.Cab;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Model.Driver;

public class BookingTransformer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,double perkmrate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistKm(bookingRequest.getTripDistKm())
                .tripStatus(TripStatus.Ongoging)
                .billAmount(bookingRequest.getTripDistKm()* perkmrate)
                .build();
    }
    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistKm(booking.getTripDistKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdated(booking.getLastUpdate())
                .customerResponse(CustomerTransformer.customertoCustomerResponse(customer))
                .cabResponse(CabTransformer.cabToCabResponse(cab,driver))
                .build();
    }
}
