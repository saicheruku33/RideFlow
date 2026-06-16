package com.sai.rideFlow.Dto.Request;

import com.sai.rideFlow.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {
    private String name;
    private int age;
    private String emailID;
    private Gender gender;

}
