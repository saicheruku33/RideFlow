package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Exception.CustomerNotFoundException;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Repository.CustomerRepo;
import com.sai.rideFlow.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer=CustomerTransformer.customerRequesttoCustomer(customerRequest);

        customerRepo.save(customer);

        return CustomerTransformer.customertoCustomerResponse(customer);


    }

    public CustomerResponse getCustomer(int customerID) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerID);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        Customer savedCustomer=optionalCustomer.get();

        return CustomerTransformer.customertoCustomerResponse(savedCustomer);
    }
}
