package com.apple.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.apple.employee.common.Common;
import com.apple.employee.entity.AppleUser;
import com.apple.employee.repository.EmployeeRegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private EmployeeRegistrationRepository employeeRegRepo;


    public AppleUser saveUser(AppleUser user) {
        user.setCreatedDateTime(Common.getCurrentDateTimeUsingDate());
        return employeeRegRepo.save(user);
    }

    public AppleUser GetUserByEmailId(String email_id) {
        return employeeRegRepo.findUserByEmailId(email_id);
    }

    public AppleUser GetUserByUserName(String userName) {

        return employeeRegRepo.findByUserName(userName);
    }

    public AppleUser GetUserByEmailIdAndPassword(String emailId, String password) {

        return employeeRegRepo.findUserByEmailIdAndPassword(emailId, password);

    }

    public List<AppleUser> getAppleUser() {
        return employeeRegRepo.findAll();
    }


}
