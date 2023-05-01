package com.apple.employee.controller;

import java.util.List;


import com.apple.employee.jwt.JwtUtil;
import com.apple.employee.exception.UserNotFoundException;
import com.apple.employee.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.employee.entity.AppleUser;
import com.apple.employee.service.RegistrationService;

@RestController
@RequestMapping("api/employee")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class EmployeeRegistrationController {

    @Autowired
    private RegistrationService registrationservice;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public AppleUser registerUser(@RequestBody AppleUser user) throws UserNotFoundException {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            AppleUser userObj = registrationservice.GetUserByEmailId(tempEmailId);
            if (userObj != null) {
                throw new UserNotFoundException("User " + tempEmailId + " is already exist");
            }
        }
        registrationservice.saveUser(user);
        return user;
    }

    @PostMapping("/login")
    public AppleUser loginUser(@RequestBody AppleUser user) throws UserNotFoundException {
        String tempUserName = user.getUserName();
        String tempPass = user.getPassword();
        AppleUser userObj = null;
        if (tempUserName != null && tempPass != null) {
            AppleUser userEmailObj = null;

            userEmailObj = registrationservice.GetUserByUserName(tempUserName);

            if (!ObjectUtils.isEmpty(userEmailObj)) {
                if (userEmailObj.getEmailId().length() > 0 && userEmailObj.getPassword().length() > 0) {
                    if (tempPass.equals(userEmailObj.getPassword())) {
                        userObj = userEmailObj;
                        return userObj;
                    } else {
                        throw new UserNotFoundException("For User " + tempUserName + " Password not matched.");
                    }
                } else {

                    throw new UserNotFoundException("User " + tempUserName + " does not exist");
                }
            } else {
                throw new UserNotFoundException("User " + tempUserName + " does not exist");
            }
        } else {
            throw new UserNotFoundException("Email and Password is required to Login");
        }
    }

    @GetMapping("/GetAllAppleUser")
    public List<AppleUser> findAllDepartments() {
        return registrationservice.getAppleUser();
    }

}
