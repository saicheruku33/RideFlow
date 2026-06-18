package com.sai.rideFlow.Dto.Request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverRequest {
    private String name;
    private int age;
    private String emailID;
}
