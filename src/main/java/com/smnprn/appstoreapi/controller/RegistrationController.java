package com.smnprn.appstoreapi.controller;

import com.smnprn.appstoreapi.model.RegistrationRequest;
import com.smnprn.appstoreapi.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0.1/registration")
@AllArgsConstructor
public class RegistrationController {
    private final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
