package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.CabRequest;
import com.sai.rideFlow.Dto.Response.CabResponse;
import com.sai.rideFlow.Exception.DriverNotFoundException;
import com.sai.rideFlow.Model.Cab;
import com.sai.rideFlow.Model.Driver;
import com.sai.rideFlow.Repository.DriverRepo;
import com.sai.rideFlow.Transformer.CabTransformer;
import com.sai.rideFlow.Transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {
    @Autowired
    DriverRepo driverRepo;
    public CabResponse registerCab(CabRequest cabRequest, int driverID) {
        Optional<Driver> optionalDriver=driverRepo.findById(driverID);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver");
        }
        Driver driver=optionalDriver.get();
        Cab cab= CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepo.save(driver);
        return CabTransformer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
