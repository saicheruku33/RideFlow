package com.sai.rideFlow.Controller;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @GetMapping("/get/customer/{customerID}")
    public CustomerResponse getCustomer(@PathVariable int customerID){
        return customerService.getCustomer(customerID);
    }
}
