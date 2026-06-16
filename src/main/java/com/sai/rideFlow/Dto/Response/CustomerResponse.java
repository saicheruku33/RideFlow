package com.sai.rideFlow.Dto.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;
    private int age;
    private String emailID;
}
