package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.model.RegistrationRequest;
import com.smnprn.appstorevisualizer.model.user.AppUser;
import com.smnprn.appstorevisualizer.model.user.AppUserRole;
import com.smnprn.appstorevisualizer.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    @PostMapping
    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());

        if(!isValid) {
            throw new IllegalStateException("Invalid email");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}