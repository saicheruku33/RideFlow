package com.sai.rideFlow.Service;

import com.sai.rideFlow.Exception.CustomerNotFoundException;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomer(int customerID) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerID);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        return optionalCustomer.get();
    }
}
