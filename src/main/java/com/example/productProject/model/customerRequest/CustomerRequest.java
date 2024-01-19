package com.example.productProject.model.customerRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequest {

    private  Long customerId;
    private String firstName;
    private String lastName;
    private String Email;
    private String mobileNo;
    private String City;

}
