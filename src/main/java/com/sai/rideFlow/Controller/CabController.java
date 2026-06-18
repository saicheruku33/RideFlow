package com.sai.rideFlow.Controller;

import com.sai.rideFlow.Dto.Request.CabRequest;
import com.sai.rideFlow.Dto.Response.CabResponse;
import com.sai.rideFlow.Model.Cab;
import com.sai.rideFlow.Model.Driver;
import com.sai.rideFlow.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    CabService cabService;

    @PostMapping("/register/{driverID}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,@PathVariable int driverID){
        return cabService.registerCab(cabRequest,driverID);

    }
}
