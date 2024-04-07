package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.model.RegistrationRequest;
import com.smnprn.appstorevisualizer.model.AppUser;
import com.smnprn.appstorevisualizer.model.AppUserRole;
import com.smnprn.appstorevisualizer.model.ConfirmationToken;
import com.smnprn.appstorevisualizer.utils.EmailSender;
import com.smnprn.appstorevisualizer.utils.EmailValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final Logger LOG = LoggerFactory.getLogger(RegistrationService.class);
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    @PostMapping
    public String register(RegistrationRequest request) {
        // TODO: implement test method
        boolean isValid = emailValidator.test(request.email());

        if(!isValid) {
            throw new IllegalStateException("Invalid email");
        }

        String token = appUserService.signUpUser(
                new AppUser(
                        request.firstName(),
                        request.lastName(),
                        request.email(),
                        request.password(),
                        AppUserRole.USER
                )
        );

        String confirmationLink = "http://localhost:8080/api/v0.1/registration/confirm?token=" + token;
        emailSender.send(request.email(), buildEmail(confirmationLink));

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return "Account confirmed";
    }

    private String buildEmail(String link) {
        String confirmationMail = "";

        try {
            confirmationMail = Jsoup.parse(new File("src/main/resources/templates/confirmationemail.html")).toString();
            confirmationMail = confirmationMail.replace("CONFIRMATION-LINK", link);
        } catch (IOException e) {
            LOG.error("Failed to parse confirmationemail.html", e);
            return "Unexpected error with the confirmation email";
        }

        return confirmationMail;
    }
}