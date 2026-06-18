package com.sai.rideFlow.Dto.Request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CabRequest {
    private String cabNo;
    private String cabModel;
    private int perkmRate;
}
