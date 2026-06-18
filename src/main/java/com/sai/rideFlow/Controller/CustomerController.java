package com.sai.rideFlow.Controller;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Enum.Gender;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @GetMapping("/get/customerid/{customerID}")
    public CustomerResponse getCustomer(@PathVariable int customerID){
        return customerService.getCustomer(customerID);
    }

    @GetMapping("/get/bygender/{gender}")
    public List<CustomerResponse>getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);
    }
    @GetMapping("/get/byageandgender")
    public List<CustomerResponse>getByGenderAndAge(@RequestParam("gender")Gender gender,
                                                   @RequestParam("age")int age){
        return customerService.getByGenderAndAge(gender,age);
    }

    @GetMapping("/get/bygenderandagegreater")
    public List<CustomerResponse>getByGenderAndAgeGreater(@RequestParam("gender")String gender,
                                                   @RequestParam("age")int age){
        return customerService.getByGenderAndAgeGreater(gender,age);
    }

    @PutMapping("/updatecustomer/{id}")
    public CustomerResponse updateCustomer(@PathVariable int id,
                                           @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(id,customerRequest);
    }
    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }

}
