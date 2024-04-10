package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.exception.*;
import com.smnprn.appstorevisualizer.model.RegistrationRequest;
import com.smnprn.appstorevisualizer.model.AppUser;
import com.smnprn.appstorevisualizer.model.AppUserRole;
import com.smnprn.appstorevisualizer.model.ConfirmationToken;
import com.smnprn.appstorevisualizer.utils.EmailSender;
import com.smnprn.appstorevisualizer.utils.EmailValidator;
import com.smnprn.appstorevisualizer.utils.RequestValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final Logger LOG = LoggerFactory.getLogger(RegistrationService.class);
    private final AppUserService appUserService;
    private final RequestValidator requestValidator;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;

    @PostMapping
    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.email());
        boolean isRequestValid = requestValidator.test(request);

        if (!isEmailValid) {
            throw new InvalidEmailException("The provided email address is invalid.");
        }

        if(!isRequestValid) {
            throw new InvalidRegistrationRequestException();
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

        try {
            emailSender.send(request.email(), buildEmail(confirmationLink));
        } catch (IOException e) {
            LOG.error("Failed to send confirmation email to user {}", request.email(), e);
            String errorMessage = """
                    Unable to send the confirmation email.
                    Please verify your account using the following confirmation token:
                    """ + token;
            throw new ConfirmationEmailException(errorMessage);
        }

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token);

        if (confirmationToken.getConfirmedAt() != null) {
            throw new EmailAlreadyConfirmedException("Email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("Token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return "Account confirmed";
    }

    private String buildEmail(String link) throws IOException {
        String confirmationMail = "";

        confirmationMail = Jsoup.parse(new File("src/main/resources/templates/confirmationemail.html")).toString();
        confirmationMail = confirmationMail.replace("CONFIRMATION-LINK", link);

        return confirmationMail;
    }
}