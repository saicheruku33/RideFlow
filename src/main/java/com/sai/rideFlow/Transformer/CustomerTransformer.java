package com.sai.rideFlow.Transformer;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Model.Customer;

public class CustomerTransformer {
    public static Customer customerRequesttoCustomer(CustomerRequest customerRequest){
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailID(customerRequest.getEmailID());
        customer.setGender(customerRequest.getGender());
        return customer;
    }
    public static CustomerResponse customertoCustomerResponse(Customer customer){

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmailID(customer.getEmailID());
        return customerResponse;
    }
}
