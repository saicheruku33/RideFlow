package com.sai.rideFlow.Dto.Response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    String name;
    int age;
    String emailID;
}
