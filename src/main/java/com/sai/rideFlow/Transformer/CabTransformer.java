package com.sai.rideFlow.Transformer;

import com.sai.rideFlow.Dto.Request.CabRequest;
import com.sai.rideFlow.Dto.Response.CabResponse;
import com.sai.rideFlow.Model.Cab;
import com.sai.rideFlow.Model.Driver;

public class CabTransformer {
    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .cabModel(cab.getCabModel())
                .perkmRate(cab.getPerkmRate())
                .available(cab.isAvailable())
                .driver(DriverTransformer.drivertoDriverResponse(driver))
                .build();
    }
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNo(cabRequest.getCabNo())
                .cabModel(cabRequest.getCabModel())
                .perkmRate(cabRequest.getPerkmRate())
                .available(true)
                .build();
    }
}
