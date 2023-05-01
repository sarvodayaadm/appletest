package com.apple.employee.models;

import lombok.Data;

@Data
public class UserRegistrationRequestModel {

    private String emailId;
    private String userName;
    private String password;

}
