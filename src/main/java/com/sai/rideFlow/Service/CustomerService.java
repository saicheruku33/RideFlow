package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
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
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailID(customerRequest.getEmailID());
        customer.setGender(customerRequest.getGender());
        Customer savedCustomer=customerRepo.save(customer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailID(savedCustomer.getEmailID());
        return customerResponse;


    }

    public CustomerResponse getCustomer(int customerID) {
        Optional<Customer> optionalCustomer=customerRepo.findById(customerID);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        Customer savedCustomer=optionalCustomer.get();
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailID(savedCustomer.getEmailID());
        return customerResponse;
    }
}
