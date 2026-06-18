package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Enum.Gender;
import com.sai.rideFlow.Exception.CustomerNotFoundException;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Repository.CustomerRepo;
import com.sai.rideFlow.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer>customers= customerRepo.findByGender(gender);

        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customertoCustomerResponse(customer));
        }
        return customerResponses;


    }

    public List<CustomerResponse> getByGenderAndAge(Gender gender, int age) {
        List<Customer>customers=customerRepo.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customertoCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getByGenderAndAgeGreater(String gender, int age) {
        List<Customer>customers=customerRepo.findByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customertoCustomerResponse(customer));
        }
        return customerResponses;
    }

    public CustomerResponse updateCustomer(int id, CustomerRequest customerRequest) {
        Optional<Customer> optionalCustomer=customerRepo.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        Customer savedCustomer=optionalCustomer.get();
        savedCustomer.setName(customerRequest.getName());
        savedCustomer.setGender(customerRequest.getGender());
        savedCustomer.setAge(customerRequest.getAge());
        savedCustomer.setEmailID(customerRequest.getEmailID());
        customerRepo.save(savedCustomer);
        return CustomerTransformer.customertoCustomerResponse(savedCustomer);
    }

    public ResponseEntity<String> deleteCustomer(int id) {
        Optional<Customer> optionalCustomer=customerRepo.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }
        Customer savedCustomer=optionalCustomer.get();
        customerRepo.deleteById(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
}
