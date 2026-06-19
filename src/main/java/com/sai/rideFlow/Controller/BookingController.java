package com.sai.rideFlow.Controller;

import com.sai.rideFlow.Dto.Request.BookingRequest;
import com.sai.rideFlow.Dto.Response.BookingResponse;
import com.sai.rideFlow.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/book/customer/{customerID}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable int customerID){
        return bookingService.bookCab(bookingRequest,customerID);

    }
}
