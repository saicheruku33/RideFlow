package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.BookingRequest;
import com.sai.rideFlow.Dto.Response.BookingResponse;
import com.sai.rideFlow.Exception.CustomerNotFoundException;
import com.sai.rideFlow.Exception.DriverNotFoundException;
import com.sai.rideFlow.Exception.cabNotFoundException;
import com.sai.rideFlow.Model.Booking;
import com.sai.rideFlow.Model.Cab;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Model.Driver;
import com.sai.rideFlow.Repository.BookingRepo;
import com.sai.rideFlow.Repository.CabRepo;
import com.sai.rideFlow.Repository.CustomerRepo;
import com.sai.rideFlow.Repository.DriverRepo;
import com.sai.rideFlow.Transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CabRepo cabRepo;
    @Autowired
    DriverRepo driverRepo;
    @Autowired
    BookingRepo bookingRepo;

    public BookingResponse bookCab(BookingRequest bookingRequest, int customerID) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerID);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer");
        }
        Customer customer=optionalCustomer.get();
        Cab availableCab=cabRepo.getAvailableCabRandomly();
        if(availableCab==null){
            throw new cabNotFoundException("no cab available");
        }

       Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,availableCab.getPerkmRate());
        Booking savedBooking=bookingRepo.save(booking);
        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);
        Driver driver=driverRepo.getDriverByCabId(availableCab.getCabID());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer=customerRepo.save(customer);
        Driver savedDriver=driverRepo.save(driver);

        return BookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);
    }
}
