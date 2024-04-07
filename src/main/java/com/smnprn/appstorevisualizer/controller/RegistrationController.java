package com.smnprn.appstorevisualizer.controller;

import com.smnprn.appstorevisualizer.model.RegistrationRequest;
import com.smnprn.appstorevisualizer.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0.1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        // If request is invalid throws a HttpMessageNotReadableException and returns 401 Unauth to user
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
