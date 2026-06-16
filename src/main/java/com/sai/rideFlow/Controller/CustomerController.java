package com.sai.rideFlow.Controller;

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
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping("/get/customer/{customerID}")
    public Customer getCustomer(@PathVariable int customerID){
        return customerService.getCustomer(customerID);
    }
}
