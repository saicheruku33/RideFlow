package com.sai.rideFlow.Controller;

import com.sai.rideFlow.Dto.Request.DriverRequest;
import com.sai.rideFlow.Dto.Response.DriverResponse;
import com.sai.rideFlow.Model.Driver;
import com.sai.rideFlow.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;
    @PostMapping("/add")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest){
        return driverService.addDriver(driverRequest);
    }
}
