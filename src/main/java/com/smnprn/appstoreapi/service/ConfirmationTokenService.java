package com.smnprn.appstoreapi.service;

import com.smnprn.appstoreapi.exception.TokenNotFoundException;
import com.smnprn.appstoreapi.repository.ConfirmationTokenRepository;
import com.smnprn.appstoreapi.model.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public ConfirmationToken getToken(String token) {
        return confirmationTokenRepository.findByToken(token).orElseThrow(
                () -> new TokenNotFoundException("Token not found, please check your confirmation token")
        );
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token,
                LocalDateTime.now()
        );
    }
}
