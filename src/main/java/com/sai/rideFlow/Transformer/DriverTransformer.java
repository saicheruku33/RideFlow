package com.sai.rideFlow.Transformer;

import com.sai.rideFlow.Dto.Request.CustomerRequest;
import com.sai.rideFlow.Dto.Request.DriverRequest;
import com.sai.rideFlow.Dto.Response.CustomerResponse;
import com.sai.rideFlow.Dto.Response.DriverResponse;
import com.sai.rideFlow.Model.Customer;
import com.sai.rideFlow.Model.Driver;

public class DriverTransformer {
    public static Driver driverRequesttoDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .emailID(driverRequest.getEmailID())
                .build();
    }
    public static DriverResponse drivertoDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .age(driver.getAge())
                .emailID(driver.getEmailID())
                .build();
    }
}
