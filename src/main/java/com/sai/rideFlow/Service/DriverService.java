package com.sai.rideFlow.Service;

import com.sai.rideFlow.Dto.Request.DriverRequest;
import com.sai.rideFlow.Dto.Response.DriverResponse;
import com.sai.rideFlow.Model.Driver;
import com.sai.rideFlow.Repository.DriverRepo;
import com.sai.rideFlow.Transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.transform.Transformer;

@Service
public class DriverService {
    @Autowired
    DriverRepo driverRepo;
    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver= DriverTransformer.driverRequesttoDriver(driverRequest);
        driverRepo.save(driver);
        return DriverTransformer.drivertoDriverResponse(driver);

    }
}
