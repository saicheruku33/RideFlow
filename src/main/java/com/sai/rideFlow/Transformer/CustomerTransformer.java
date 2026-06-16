package com.sai.rideFlow.Transformer;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Model.Customer;

public class CustomerTransformer {
    public static Customer customerRequesttoCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailID(customerRequest.getEmailID())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerResponse customertoCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .emailID(customer.getEmailID())
                .build();
    }
}
